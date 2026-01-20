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
