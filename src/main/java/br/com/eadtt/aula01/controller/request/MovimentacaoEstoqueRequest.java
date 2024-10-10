package br.com.eadtt.aula01.controller.request;

import lombok.Data;

import java.util.List;

@Data
public class MovimentacaoEstoqueRequest {
    private List<Long> idPecas;
    private Long idLojaDestino;
}
