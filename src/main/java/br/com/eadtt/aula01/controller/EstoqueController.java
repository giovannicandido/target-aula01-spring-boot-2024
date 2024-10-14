package br.com.eadtt.aula01.controller;

import br.com.eadtt.aula01.Constants;
import br.com.eadtt.aula01.controller.request.MovimentacaoEstoqueRequest;
import br.com.eadtt.aula01.model.Carro;
import br.com.eadtt.aula01.service.CarroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.V0 + "/estoques")
@Slf4j
public class EstoqueController {

    private final CarroService carroService;

    public EstoqueController(CarroService carroService) {
        this.carroService = carroService;
    }

    @PostMapping("/{id}/actions/movimentar")
    public void movimentar(@PathVariable("id") Long estoqueId,
                           @RequestParam(name = "atendente", required = false) String atendente,
                           @RequestBody MovimentacaoEstoqueRequest movimentoEstoque
                           ) {
        log.info("Movimento de estoque para estoque %s, peca %s loja de destino %s".formatted(
                estoqueId,
                movimentoEstoque.getIdPecas(),
                movimentoEstoque.getIdLojaDestino()

        ));
        log.info("Atendente: %s".formatted(atendente));
    }

    @GetMapping("/teste")
    public List<Carro> getCarrosTeste() {
        return carroService.getAllCarros();
    }
}
