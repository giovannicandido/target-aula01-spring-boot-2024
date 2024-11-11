package br.com.eadtt.aula01.controller.request;

import br.com.eadtt.aula01.model.Endereco;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EnderecoRequestTest {

    // Given when then
    @Test
    void givenEndereco_whenFromModel_thenReturnEnderecoRequest() {
        Endereco endereco = new Endereco();
        endereco.setId(1);
        endereco.setNumero(200);
        endereco.setLogradouro("Teste Logradouro");
        endereco.setBairro("Teste Bairro");


        EnderecoRequest enderecoRequest = EnderecoRequest.fromModel(endereco);

        assertNotNull(enderecoRequest);
        assertEquals(enderecoRequest.getBairro(), endereco.getBairro());

        assertThat(enderecoRequest).isNotNull();
        assertThat(enderecoRequest.getLogradouro()).isEqualTo(endereco.getLogradouro());

        assertThat(enderecoRequest)
                .usingRecursiveComparison()
                .isEqualTo(endereco);
    }

    // Given when then
    @Test
    void givenEnderecoRequest_whenToModel_thenReturnEndereco() {
        // given
        EnderecoRequest enderecoRequest = new EnderecoRequest();
        enderecoRequest.setNumero(200);
        enderecoRequest.setLogradouro("Teste Logradouro");
        enderecoRequest.setBairro("Teste Bairro");

        // when
        Endereco endereco = enderecoRequest.toModel();

        // then
        assertThat(endereco).isNotNull();
        assertThat(endereco)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(enderecoRequest);
    }
}