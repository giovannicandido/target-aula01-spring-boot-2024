package br.com.eadtt.aula01.model.events;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class FinalizacaoAtendimento {
    private Integer idAtendimento;
    private Integer idCliente;
    private LocalDateTime dataFinalizacao;
    private String nomeCliente;
    private String email;
}
