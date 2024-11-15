package br.com.eadtt.aula01.data.stub;

import br.com.eadtt.aula01.model.Endereco;

public class EnderecoStub {
    public static Endereco create() {
        return Endereco.builder()
                .bairro("Jardim Carvalho")
                .numero(500)
                .logradouro("Attilio Bilibio")
                .build();
    }
}
