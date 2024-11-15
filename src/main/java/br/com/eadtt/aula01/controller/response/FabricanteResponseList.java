package br.com.eadtt.aula01.controller.response;

import br.com.eadtt.aula01.model.Fabricante;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
@Getter
@Setter
public class FabricanteResponseList {
    private List<FabricanteResponse> fabricantes;

    public static FabricanteResponseList fromModel(List<Fabricante> fabricantes) {
        if(Objects.isNull(fabricantes)) {
            return new FabricanteResponseList(new ArrayList<>());
        }

        return FabricanteResponseList.builder()
                .fabricantes(fabricantes.stream().map(FabricanteResponse::fromModel).toList())
                .build();

    }
}
