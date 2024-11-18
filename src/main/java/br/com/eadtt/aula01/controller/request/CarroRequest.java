package br.com.eadtt.aula01.controller.request;

import br.com.eadtt.aula01.validators.CaseMatch;
import br.com.eadtt.aula01.validators.CaseType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CarroRequest {
    private String marca;
    private String modelo;
    private Integer ano;
    @CaseMatch(caseType = CaseType.UPPER)
    @NotBlank
    private String placaCarro;

    @NotNull
    @Min(1)
    private Integer fabricanteId;

    @NotNull
    @Min(1)
    private Integer donoId;
}
