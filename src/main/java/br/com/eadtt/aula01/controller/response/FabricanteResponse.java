package br.com.eadtt.aula01.controller.response;

import br.com.eadtt.aula01.model.Fabricante;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class FabricanteResponse {

    private String nome;

    public static FabricanteResponse fromModel(Fabricante fabricante) {
        return FabricanteResponse.builder()
                .nome(fabricante.getNome())
                .build();
    }
}
