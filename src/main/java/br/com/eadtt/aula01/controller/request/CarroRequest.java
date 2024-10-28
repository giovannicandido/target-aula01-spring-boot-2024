package br.com.eadtt.aula01.controller.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CarroRequest {
    private String marca;
    private String modelo;
    private Integer ano;
    private String placaCarro;

    @NotNull
    @Min(1)
    private Integer fabricanteId;

    @NotNull
    @Min(1)
    private Integer donoId;
}
