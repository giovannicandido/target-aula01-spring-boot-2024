package br.com.eadtt.aula01.config;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "oficina.kafka")
@Component
@Getter
@Setter
public class OficinaKafkaConfig {
    private String bootstrapServers;
    private String atendimentoTopic;
    // Properties personalizadas podem ter validação também, mas tem que habilitar (não fucionou agora)
    @NotNull
    private Producer producer;

    @Getter
    @Setter
    public static class Producer {
        @NotNull
        private Integer acks;
    }
}


