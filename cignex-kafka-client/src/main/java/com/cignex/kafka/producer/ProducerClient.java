package com.cignex.kafka.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * 
 * @author vishal.rangras
 *
 */
public class ProducerClient {

	public static void main(String[] args) {
		Properties props = new Properties();
		 props.put("bootstrap.servers", "localhost:9092");
		 props.put("acks", "all");
		 props.put("retries", 0);
		 props.put("batch.size", 16384);
		 props.put("linger.ms", 1);
		 props.put("buffer.memory", 33554432);
		 props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		 props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		 Producer<String, String> producer = new KafkaProducer<String, String>(props);
		 System.out.println("Starting the producer");
		 
		 producer.send(new ProducerRecord<String, String>("java-topic", "Msg:", "Publishing data to Kafka Topic from Java Producer"));
		 producer.send(new ProducerRecord<String, String>("java-topic", "Msg:", "Another message from Java Producer"));
		 System.out.println("Data sent, now closing the producer.");
		 producer.close();

	}

}
