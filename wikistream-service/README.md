# Wikistream Service
    A practical demonstration of Kafka streaming where a Kafka producer publishes data to topics on each update, and 
    a Kafka consumer processes those messages and stores them in a database. 

## Requirements
- **Apache Kafka** – for event streaming
- **Java 17+** – application runtime
- **MySQL Server** – for persistent data storage


## Environment Variables

Create a `.env` file in each service and configure the following variables:

**kafka-producer-wikimedia/.env**
```env
WIKIMEDIA_STREAM_URL={WIKIMEDIA_URL}
```

**kafka-consumer-database/.env**
```env
KAFKA_SERVER={YOUR_KAFKA_SERVER}
DB_NAME={YOUR_DB_NAME}
DB_USERNAME={YOUR_DB_USERNAME}
DB_PASSWORD={YOUR_DB_PASSWORD}
```


# Project Structure

```
Wikistream-Service
│
├── kafka-producer-wikimedia
│   ├── src
│   └── pom.xml
│
├── kafka-consumer-database
│   ├── src
│   └── pom.xml
│
└── README.md```
