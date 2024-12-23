package com.etiya.productservice;

import com.etiya.event.OrderCreatedEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.sabaurgup.annotations.EnableCore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@EnableCore
public class ProductserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);
    }

    @KafkaListener(topics = { "orderTopic" }, groupId = "productService")
    public void listenAddedOrderEvent(OrderCreatedEvent event) throws JsonProcessingException {
        System.out.println("Kafka bir mesaj gönderdi:" + event.getId());
    }
}
