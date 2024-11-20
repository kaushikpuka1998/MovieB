package com.example.MovieB.Services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerListener {

    @KafkaListener(topics = "cinemaHallTopic", groupId = "movieb-group")
    public void listen(Object message) {
        // Process the message
        System.out.println("Received message: " + message);
    }
}
