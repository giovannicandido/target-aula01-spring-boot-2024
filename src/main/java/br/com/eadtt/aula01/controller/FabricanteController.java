package br.com.eadtt.aula01.controller;

import br.com.eadtt.aula01.Constants;
import br.com.eadtt.aula01.controller.request.FabricanteDTO;
import br.com.eadtt.aula01.controller.response.FabricanteResponse;
import br.com.eadtt.aula01.controller.response.FabricanteResponseList;
import br.com.eadtt.aula01.model.Endereco;
import br.com.eadtt.aula01.model.Fabricante;
import br.com.eadtt.aula01.service.FabricanteService;
import jakarta.validation.Valid;
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
    public FabricanteDTO create(@RequestBody @Valid FabricanteDTO fabricanteRequest) {
        fabricanteService.create(fabricanteRequest.toModel());
        return fabricanteRequest;
    }

    @GetMapping
    public FabricanteResponseList getAll() {
        return FabricanteResponseList.fromModel(fabricanteService.findAll());
    }

    @GetMapping("/{id}")
    public FabricanteResponse get(@PathVariable Integer id) {
        return FabricanteResponse.fromModel(fabricanteService.findById(id));
    }
}
