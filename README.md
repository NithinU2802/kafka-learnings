# Apache Kafka

  Apache Kafka is a distributed event streaming platform for building real-time data pipelines and streaming applications, allowing you to publish, subscribe to, store and process stream of records as events reliably and at high throughput.

  It acts like a high-performance, fault-tolerant messaging system, organized into topics with partitions, where producers write data and consumers read it, enabling decoupling of systems and scalable data integration.

# What is Apache Kafka?

  Apache kafka is distributed event streaming platform used to:
    1. Publish Data (event)
    2. Store data durably
    3. Process data in real time
  Think of a kafka as a high-speed, fault-tolerant message backbone for large systems.

# Why kafka?

Kafka is mainly used for
- Real-time data piplines
- Microservices communication (event-driven architecture)
- Log aggregation
- Streaming analytics

**Example:** User places an order → Kafka sends this event → Inventory, Payment, Notification services consume it independently.

# Core Kafka Concepts
- Producer (Sends message (events) to kafka. Eg: Order Service sending order event)
- Consumer (Reads message from kafka. Eg: Email Service consuming order event)
- Topic (A category/stream of messages. Eg: order-events)
- Partition (Each topic is split into partitions, enables parallel processing, messages inside a partition are ordered. More partitions = More Throughput)
- Broker (A kafka server, A kafka cluster = multiple brokers)
- Consumer Group (A group of consumers working together. Each partition is consumed by only one consumer in a group - scalability)
- Offset (Position of a message in a partition. Kafka store offsets and consumers can replay messages.

# Simple Flow
```Producer → Topic → Partition → Consumer Group → Consumer```

# Kafka vs REST API
Synchronous VS Asynchronous
Tight Coupling VS Loose Coupling
One-to-one VS One-to-many
Slower at scale VS Very fast & Scalable

# KRaft
- It is the build in system.
- To help manage its own metadata also cluster coordination internally.
- It is simpler and easier way to operate things itself.

# Bootstrap Servers
It provides the initial hosts which act as the starting point for a kafka
client to discover the full set of alive servers in the cluster.

# Producer produce
This is used to produce a topic in kafka and store the events created by the
service. Incase if the topic is not available it will create the load as well.

# Producer Flush
It is used to append the value as a batch instead of loading one by one to the
kafka. Eg: to collect 10 and load as batch to the kafka accordingly. Also incase if the application crashes then it will load the
items before exiting the program.

# Kafka CLI (docker)

```bash
docker exec -it kafka kafka-topics --list --bootstrap-server localhost:9092
```

```bash
docker exec -it kafka kafka-topics --bootstrap-server localhost:9092 --describe --topic orders
```

```bash
docker exec -it kafka kafka-topics --bootstrap-server localhost:9092 --help
```

```bash
docker exec -it kafka kafka-console-consumer --bootstrap-server localhost:9092 --help
```

```bash
docker exec -it kafka kafka-console-consumer --bootstrap-server localhost:9092 --topic orders --from-beginning
```

# Consumer Group Id
It is a unique string that identifies the consumer group which the consumer belongs to.

# Auto offset reset
It determines where a consumer starts reading messages when no valid offset exists. Below are different options:
1. Earliest - automatically reset the offset to the earliest offset.
2. Latest - automatically reset the offset to the latest offset.
3. by_duration:<duration> - automatically reset the offset to a configured <duration> from the current timestamp.
4. none: throw exception to the consumer if no previous offset is found for the consumer's group/

# Kafka Poll
It is designed so that consumers can ask or pull the brokder if there are new messages instead of kafka pushing the messages to them on its own.

This polling let the consumers as same consumer subscribe to multiple topics. Which can control how many times they read those events and messages from different topics.

Note: It helps in Load balancing, pausing, catching up, simple, reliable, scalable, controllable.

# Kafks Subscribe
To registers interest in one or more topics and puts the consumer into a consumer group.

# Close Method
It is crucial for properly releasing resource associate with a consumer instance. Which ensures that network connections and file handles are closed, offsets are committed and the consumer's partition assignments are revoked.
