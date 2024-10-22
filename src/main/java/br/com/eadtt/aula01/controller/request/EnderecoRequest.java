package br.com.eadtt.aula01.controller.request;

import br.com.eadtt.aula01.model.Endereco;
import lombok.Data;

@Data
public class EnderecoRequest {
    private String logradouro;
    private Integer numero;
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
