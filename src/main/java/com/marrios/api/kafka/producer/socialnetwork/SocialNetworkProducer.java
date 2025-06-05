package com.marrios.api.kafka.producer.socialnetwork;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SocialNetworkProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public SocialNetworkProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void createSocialNetworkMessage(String message) {
        System.out.println("Send: " + message);
        kafkaTemplate.send("topico-dev", message);
    }
}
