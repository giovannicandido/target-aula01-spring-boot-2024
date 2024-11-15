package br.com.eadtt.aula01.controller.request;

import br.com.eadtt.aula01.model.Fabricante;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FabricanteDTO {

    @NotBlank
    private String nome;

    @NotNull
    @Valid
    private EnderecoRequest endereco;

    public static FabricanteDTO fromModel(Fabricante fabricante) {
        FabricanteDTO fabricanteDTO = new FabricanteDTO();
        fabricanteDTO.setNome(fabricante.getNome());
        fabricanteDTO.setEndereco(EnderecoRequest.fromModel(fabricante.getEndereco()));
        return fabricanteDTO;
    }

    public Fabricante toModel() {
        Fabricante fabricante = new Fabricante();
        fabricante.setNome(this.nome);
        fabricante.setEndereco(endereco.toModel());
        return fabricante;
    }
}
