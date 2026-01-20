package com.wikistream.main;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class WikimediaChangesProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesProducer.class);
	
	@Value("${wikimedia.stream.url}")
	private String url;
	
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public WikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate=kafkaTemplate;
	}
	
	public void sendMessage() throws InterruptedException{
		String topic = "wikimedia_updates";
		
		// to read real time streaming data from wikimedia using event source
		EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topic);
		
		OkHttpClient client = new OkHttpClient.Builder()
			.addInterceptor(chain -> {
				Request original = chain.request();
				Request request = original.newBuilder()
					.addHeader("Accept", "text/event-stream")
					.addHeader("Cache-Control", "no-cache")
					.addHeader("User-Agent", "WikimediaChangesProducer/1.0")
					.build();
				return chain.proceed(request);
			})
			.build();
		
		EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url))
			.client(client);
		EventSource eventSource = builder.build();
		eventSource.start();
		
		TimeUnit.MINUTES.sleep(10);
		
	}
	
	
}
