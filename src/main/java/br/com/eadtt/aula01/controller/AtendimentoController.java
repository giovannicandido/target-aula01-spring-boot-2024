package br.com.eadtt.aula01.controller;

import br.com.eadtt.aula01.Constants;
import br.com.eadtt.aula01.service.AtendimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.V0 + "/atendimentos")
@RequiredArgsConstructor
public class AtendimentoController {
    private final AtendimentoService atendimentoService;

    @PostMapping("/{idAtendimento}/actions/finalizar")
    public void finalizarAtendimento(@PathVariable Integer idAtendimento) {
        atendimentoService.finalizarAtendimento(idAtendimento);
    }
}
