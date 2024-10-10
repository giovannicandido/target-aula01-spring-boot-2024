package br.com.eadtt.aula01.controller;

import br.com.eadtt.aula01.Constants;
import br.com.eadtt.aula01.controller.request.DeleteOficinaFilterRequest;
import br.com.eadtt.aula01.controller.request.EntradaVeiculoRequest;
import br.com.eadtt.aula01.controller.request.OficinaRequest;
import br.com.eadtt.aula01.controller.request.MovimentacaoEstoqueRequest;
import br.com.eadtt.aula01.controller.response.CarroResponseList;
import br.com.eadtt.aula01.controller.response.ConfirmationMessage;
import br.com.eadtt.aula01.controller.response.OficinaResponse;
import br.com.eadtt.aula01.controller.response.OficinaResponseList;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(Constants.V0 + "/oficinas")
@Slf4j
public class OficinaController {

    @GetMapping()
    @ResponseBody
    public OficinaResponseList getAllOficinas() {
        OficinaResponseList response = new OficinaResponseList(
                List.of(new OficinaResponse(1L, "oficina1"), new OficinaResponse(2L,"oficina2"))
        );
        return response;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OficinaResponse createNewOficina(@RequestBody OficinaRequest oficinaRequest) {
        return new OficinaResponse(333L, oficinaRequest.getNome());
    }

    @PutMapping("/{id}")
    public OficinaResponse updateOficina(
            @PathVariable(name = "id") Long id,
            @RequestBody OficinaRequest oficinaRequest) {
        return new OficinaResponse(id, oficinaRequest.getNome());
    }

    // Deletar em lote
    @DeleteMapping()
    public void updateOficina(
            @RequestBody DeleteOficinaFilterRequest filter
            ) {

    }

    @DeleteMapping("/{id}")
    public void updateOficina(
            @PathVariable(name = "id") Long id
            ) {

    }

    // Faz mais sentido em um controlador de estoque
    @PostMapping("/{id}/acao/mover-peca/{idPeca}")
    public void moverPeca(@PathVariable(name = "id") Long id, @RequestBody MovimentacaoEstoqueRequest operacao) {

    }


    @GetMapping("/{id}/carros")
    @ApiResponses(value = {
            @ApiResponse(description = "Lista de carros com seus respectivos dados do banco", responseCode = "200")
    })
    public CarroResponseList getCarrosOficina(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping("/{id}/carros/{id-carro}/seguros")
    public CarroResponseList getSegurosCarroOficina(@PathVariable("id") Long id,
                                              @PathVariable("id-carro") Long idCarro) {
        return null;
    }

    @PostMapping("/{id}/actions/entrada")
    public ProblemDetail entrarVeiculo(
            @PathVariable("id") Long oficinaId,
            @RequestBody EntradaVeiculoRequest entrada) {
        log.info("Entrada de veiculo: {}", entrada);

        ConfirmationMessage confirmationMessage = new ConfirmationMessage();
        confirmationMessage.setStatus(ConfirmationMessage.Status.OK);
        confirmationMessage.setConfirmationMessages(
                List.of(new ConfirmationMessage.Message("Entrada de veiculo executada com sucesso", "ENTRADA_VEICULO_OK"))
        );
        // ProblemDetail é padronizado: https://apibestpractices.info/errors/problem-details
        ProblemDetail problemDetail = ProblemDetail.forStatus(200);
        problemDetail.setInstance(URI.create("/oficinas/%s/actions/entrada".formatted(oficinaId)));
        problemDetail.setTitle("Entrada de veiculo");
        problemDetail.setDetail("Entrada de veiculo executada com sucesso");
        problemDetail.setType(URI.create("/api-doc/status/entrada-veiculo-executada-com-sucesso"));
        return problemDetail;

    }
}
