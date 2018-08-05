from kafka import KafkaProducer

def producer():
    producer = KafkaProducer(bootstrap_servers='localhost:9092')
    producer.send('python-topic', b"Publishing data to Kafka Topic from Python Producer")
    producer.send('python-topic', b"Another message from Python Producer")
    producer.close()

if __name__ == "__main__":
    producer()
