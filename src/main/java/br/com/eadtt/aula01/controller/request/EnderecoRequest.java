package br.com.eadtt.aula01.controller.request;

import br.com.eadtt.aula01.model.Endereco;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EnderecoRequest {
    @NotBlank
    private String logradouro;

    @NotNull
    @Min(1)
    private Integer numero;

    @NotBlank
    private String bairro;

    public static EnderecoRequest fromModel(Endereco endereco) {
        EnderecoRequest enderecoRequest = new EnderecoRequest();
        enderecoRequest.setLogradouro(endereco.getLogradouro());
        enderecoRequest.setNumero(endereco.getNumero());
        enderecoRequest.setBairro(endereco.getBairro());
        return enderecoRequest;
    }

    public Endereco toModel() {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(logradouro);
        endereco.setNumero(numero);
        endereco.setBairro(bairro);
        return endereco;
    }
}
