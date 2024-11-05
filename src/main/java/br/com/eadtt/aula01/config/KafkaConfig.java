package br.com.eadtt.aula01.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic atendimento() {
        return new NewTopic("atendimento", 1, (short) 1);
    }
}
