package com.marrios.api.kafka.consumer.socialnetwork;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SocialNetworkConsumer {
    @KafkaListener(topics = "topico-dev", groupId = "grupo-dev")
    public void createSocialNetworkListener(String mensagem) {
        System.out.println("Recebido PELO DEV: " + mensagem);
    }

    @KafkaListener(topics = "topico-dev", groupId = "grupo-hehe")
    public void createSocialNetworkHeheListener(String mensagem) {
        System.out.println("Recebido PELO HEHE: " + mensagem);
    }
}
