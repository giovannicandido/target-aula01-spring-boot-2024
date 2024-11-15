package br.com.eadtt.aula01.data.stub;

import br.com.eadtt.aula01.model.Fabricante;

import java.util.List;

public class FabricanteStub {

    public static Fabricante create(String nome) {
        return Fabricante.builder()
                .nome(nome)
                .endereco(EnderecoStub.create())
                .build();
    }

    public static List<Fabricante> createList() {
        return List.of(create("Fiat"), create("Volkswagen"), create("BYD"));
    }
}
