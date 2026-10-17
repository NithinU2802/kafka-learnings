from confluent_kafka import Producer
import uuid
import json

producer_config = {'bootstrap.servers': 'localhost:9092'}

producer = Producer(producer_config)

def delivery_report(err, msg):
    if err:
        print(f"Delivery report error: {err}")
    else:
        print(f"Delivered: {msg.value().decode("utf-8")}")
        print(dir(msg)) # to inspect incase of finding issue
        print(f"Delivered to {msg.topic()}: partition {msg.partition()}: at offset {msg.offset()}")

order = {
    'order_id': str(uuid.uuid4()),
    'user': 'nithin',
    'item': 'naan',
    'quantity': 4
}

value = json.dumps(order).encode("utf-8")

producer.produce(topic='orders', value=value, callback=delivery_report)

producer.flush()