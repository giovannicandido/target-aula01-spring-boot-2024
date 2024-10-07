package br.com.eadtt.aula01.controller.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MovimentacaoEstoqueRequest {
    private ActionId action;
    private Long idPeca;
    private LocalDate dataMovimentacao;
    private Long idLojaDestino;
}
