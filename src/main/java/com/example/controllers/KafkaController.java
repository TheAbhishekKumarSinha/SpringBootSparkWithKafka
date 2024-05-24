package com.example.controllers;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.producers.KafkaProducers;
import com.example.request.CacheFilter;
import com.example.request.OrderBy;
import com.example.request.SparkRequest;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@RestController
//@RequestMapping("/EnrichedInquiry")
public class KafkaController {

    @Autowired
    private KafkaProducers messageProducer;

    @GetMapping("/top5year")
    public String sendMessage(@RequestParam("message") String message) {
        //messageProducer.sendToKafka(message);
        SparkRequest request = new SparkRequest();
        request.setCollectionName("EnrichedInquiry");
        request.setDatabaseName("CAT_TRADING");
        request.setCacheFilter(CacheFilter.builder().startDate(LocalDateTime.now().minusYears(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli())
        .endDate(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()).build());
        ArrayList<OrderBy> list = new ArrayList<OrderBy>();
        list.add(OrderBy.builder().orderByColumn("").orderByDirection("ASC").build());
        messageProducer.sendToKafka(request);
        return "Message sent: " + message;
    }


}
