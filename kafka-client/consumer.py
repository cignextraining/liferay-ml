#!/usr/bin/env python
from kafka import KafkaConsumer

def consume():
    consumer = KafkaConsumer(bootstrap_servers='localhost:9092',
                                 auto_offset_reset='earliest',
                                 consumer_timeout_ms=1000)
    consumer.subscribe(['java-topic'])
    print("Starting the consumption")
    while True:
        for message in consumer:
            print("offset:%d, partition:%d, key=%s, value=%s"%(message.offset, message.partition, message.key, message.value))


if __name__ == "__main__":
#    logging.basicConfig(
#        format='%(asctime)s.%(msecs)s:%(name)s:%(thread)d:%(levelname)s:%(process)d:%(message)s',
#        level=logging.INFO
#        )
    consume()
