package br.com.eadtt.aula01.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
    @Autowired
    private OficinaKafkaConfig oficinaKafkaConfig;

    @Autowired
    private ObjectMapper objectMapper;


    @Bean
    public NewTopic atendimento() {
        return new NewTopic(oficinaKafkaConfig.getAtendimentoTopic(), 1, (short) 1);
    }

    public Map<String, Object> producerConfigs() {
        var props = new HashMap<String, Object>();
        props.put("bootstrap.servers", oficinaKafkaConfig.getBootstrapServers());
        // A chave tem que ser a correta do spring kafka, aqui é chute
        props.put("producer.acks", oficinaKafkaConfig.getProducer().getAcks());
        return props;
    }

    @Bean
    @Primary
    public ProducerFactory<Object, Object> producerFactory() {
        JsonSerializer<Object> jsonSerializer = new JsonSerializer<Object>(objectMapper);

        DefaultKafkaProducerFactory<Object, Object> producerFactory =
                new DefaultKafkaProducerFactory<>(producerConfigs());
        producerFactory.setValueSerializer(jsonSerializer);
        producerFactory.setKeySerializer(new StringObjectSerializer());
        return producerFactory;
    }

    public static class StringObjectSerializer implements Serializer<Object> {
        private final StringSerializer stringSerializer = new StringSerializer();
        @Override
        public void configure(Map<String, ?> configs, boolean isKey) {
            stringSerializer.configure(configs, isKey);
        }

        @Override
        public byte[] serialize(String s, Object o) {
            return stringSerializer.serialize(s, o.toString());
        }

        @Override
        public byte[] serialize(String topic, Headers headers, Object data) {
            return stringSerializer.serialize(topic, headers, data.toString());
        }

        @Override
        public void close() {
            stringSerializer.close();
        }
    }
}
