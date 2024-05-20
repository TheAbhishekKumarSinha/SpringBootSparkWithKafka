package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.producers.KafkaProducers;
import com.example.request.SparkRequest;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class KafkaController {

    @Autowired
    private KafkaProducers messageProducer;

    @GetMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        //messageProducer.sendToKafka(message);
        SparkRequest request = new SparkRequest();
        request.setCollectionName("collection");
        request.setDatabaseName("database");
        messageProducer.sendToKafka(request);
        return "Message sent: " + message;
    }


}
