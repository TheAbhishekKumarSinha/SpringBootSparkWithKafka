package com.example.kafka.producers;

import java.util.concurrent.CompletableFuture;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import com.example.request.SparkRequest;

@Component
public class KafkaProducers {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    public void sendToKafka(final String data) {
        //final ProducerRecord<String, String> record = createRecord(data);
    
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("spark-channel", data);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                //handleSuccess(data);
            }
            else {
                //handleFailure(data, record, ex);
            }
        });
    }
}
