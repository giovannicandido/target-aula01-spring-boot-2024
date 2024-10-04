package br.com.eadtt.aula01.controller;

import br.com.eadtt.aula01.Constants;
import br.com.eadtt.aula01.controller.request.CarroRequest;
import br.com.eadtt.aula01.controller.response.CarroResponse;
import br.com.eadtt.aula01.model.Carro;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(Constants.V0 + "/carros")
public class CarroController {

    // O path no REST identifica o recurso, ou a api
    @GetMapping(produces = "application/json")
    public CarroResponseList getAllCarros() {
        CarroResponseList carroResponseList = new CarroResponseList(List.of(new CarroResponse(1, "Ford", "Focus", 2019)));
        return carroResponseList;
    }

    @PostMapping()
    public CarroResponse createNewCarro(@RequestBody CarroRequest request) {
        return new CarroResponse();
    }

    @PutMapping(path = "/{id}")
    public CarroResponse updateCarroById(@RequestBody CarroRequest request, @PathVariable("id") Integer id) {

        return new CarroResponse();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCarroById(@PathVariable("id") Integer id) {
        log.info("Deletando carro de id %s".formatted(id));
    }


}
