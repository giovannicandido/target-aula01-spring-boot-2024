package br.com.eadtt.aula01.service;

import br.com.eadtt.aula01.model.Atendimento;
import br.com.eadtt.aula01.model.Cliente;
import br.com.eadtt.aula01.model.EntradaCarro;
import br.com.eadtt.aula01.model.Pagamento;
import br.com.eadtt.aula01.model.events.FinalizacaoAtendimento;
import br.com.eadtt.aula01.model.exceptions.EntityNotFoundInDatabaseException;
import br.com.eadtt.aula01.model.exceptions.PaymentNotFoundException;
import br.com.eadtt.aula01.repository.AtendimentoRepository;
import br.com.eadtt.aula01.repository.PagamentoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;
    private final EntradaCarroService entradaCarroService;
    private final PagamentoRepository pagamentoRepository;

    private final KafkaTemplate<String, FinalizacaoAtendimento> kafkaTemplate;

    @Transactional
    public void finalizarAtendimento(Integer idAtendimento) {

        Atendimento atendimento = atendimentoRepository.findById(idAtendimento)
                .orElseThrow(() -> new EntityNotFoundInDatabaseException("Atendimento", idAtendimento.toString()));

        findPagamento(idAtendimento).orElseThrow(() -> new PaymentNotFoundException(atendimento.getCliente().getId(), idAtendimento, LocalDateTime.now()));

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



        kafkaTemplate.send("atendimento", idAtendimento.toString(), finalizacaoAtendimento);
    }

    public Optional<Pagamento> findPagamento(Integer idAtendimento) {
        return pagamentoRepository.findByAtendimento_Id(idAtendimento);
    }
}
