package br.com.eadtt.aula01.service;

import br.com.eadtt.aula01.model.Atendimento;
import br.com.eadtt.aula01.model.Cliente;
import br.com.eadtt.aula01.model.EntradaCarro;
import br.com.eadtt.aula01.model.events.FinalizacaoAtendimento;
import br.com.eadtt.aula01.model.exceptions.EntityNotFoundInDatabaseException;
import br.com.eadtt.aula01.repository.AtendimentoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AtendimentoService {

    private AtendimentoRepository atendimentoRepository;
    private EntradaCarroService entradaCarroService;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Transactional
    public void finalizarAtendimento(Integer idAtendimento) {

        Atendimento atendimento = atendimentoRepository.findById(idAtendimento)
                .orElseThrow(() -> new EntityNotFoundInDatabaseException("Atendimento", idAtendimento.toString()));

        EntradaCarro entradaCarro = atendimento.getEntradaCarro();

        atendimento.setDataFinalizacao(LocalDateTime.now());
        entradaCarroService.darBaixaEntrada(entradaCarro.getId());
        atendimentoRepository.save(atendimento);

        Cliente cliente = atendimento.getCliente();

        FinalizacaoAtendimento finalizacaoAtendimento = FinalizacaoAtendimento.builder()
                .idCliente(cliente.getId())
                .nomeCliente(cliente.getNome())
                .email(cliente.getEmail())
                .idAtendimento(idAtendimento)
                .dataFinalizacao(LocalDateTime.now())
                .build();

        String finalizacaoJson = null;
        try {
            finalizacaoJson = objectMapper.writeValueAsString(finalizacaoAtendimento);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        kafkaTemplate.send("atendimento", idAtendimento.toString(), finalizacaoJson);
    }
}
