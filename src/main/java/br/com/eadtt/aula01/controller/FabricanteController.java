package br.com.eadtt.aula01.controller;

import br.com.eadtt.aula01.Constants;
import br.com.eadtt.aula01.controller.request.FabricanteDTO;
import br.com.eadtt.aula01.model.Endereco;
import br.com.eadtt.aula01.model.Fabricante;
import br.com.eadtt.aula01.service.FabricanteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@Slf4j
@RequestMapping(Constants.V0 + "/fabricantes")
public class FabricanteController {

    private final FabricanteService fabricanteService;

    public FabricanteController(FabricanteService fabricanteService) {
        this.fabricanteService = fabricanteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FabricanteDTO create(@RequestBody FabricanteDTO fabricanteRequest) {
        fabricanteService.create(fabricanteRequest.toModel());
        return fabricanteRequest;
    }

    @GetMapping
    public List<Fabricante> getAll() {
        List<Fabricante> fabricantes = fabricanteService.findAll();
        return fabricantes;
//        return fabricanteService.findAll()
//                .stream()
////                .map(FabricanteDTO::fromModel)
//                .toList();
    }
}
