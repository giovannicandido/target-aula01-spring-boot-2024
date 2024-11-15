package br.com.eadtt.aula01.controller;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.kafka.KafkaContainer;

@Testcontainers
public abstract class TestContainerSetup {
    @Container
    static KafkaContainer kafka = new KafkaContainer("apache/kafka-native:3.8.0");


    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.kafka.bootstrap-servers", () -> kafka.getBootstrapServers());
        registry.add("oficina.kafka.bootstrap-servers", kafka::getBootstrapServers);
    }

}
