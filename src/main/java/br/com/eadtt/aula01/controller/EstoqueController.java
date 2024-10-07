package br.com.eadtt.aula01.controller;

import br.com.eadtt.aula01.Constants;
import br.com.eadtt.aula01.controller.request.MovimentacaoEstoqueRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.V0 + "/estoques")
public class EstoqueController {

    @PostMapping("/{id}/actions")
    public void movimentar(@PathVariable("id") Long estoqueId,
                           @RequestBody MovimentacaoEstoqueRequest movimentoEstoque
                           ) {}
}
