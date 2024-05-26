package com.example.kafka.consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.spark.SparkMongoReader;
import com.example.spark.request.SparkRequest;
import com.example.spark.response.SparkResponse;


@Component
public class KafkaConsumers implements IKafkaConsumers {

    @Autowired
    private SparkMongoReader sparkMongoReader;

    @KafkaListener(topics = "spark-channel", groupId = "my-group-id")
    public void listen(SparkRequest message) {
        System.out.println("Received message: " + message);
        sparkMongoReader.readFromMongoUsingSpark();
        
    }

    @KafkaListener(topics = "spark-channel-response", groupId = "my-group-id2")
    public void listen(SparkResponse message) {
        System.out.println("Received message: " + message);
    }

}
