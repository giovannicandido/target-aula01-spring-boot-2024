package br.com.eadtt.aula01.controller;

import br.com.eadtt.aula01.model.Carro;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/carros")
public class CarroController {

    // O path no REST identifica o recurso, ou a api
    @GetMapping(produces = "application/json")
    public List<Carro> getAllCarros() {
        return List.of(new Carro(1, "Ford", "Focus", 2019));
    }

    @PostMapping()
    public Carro createNewCarro(@RequestBody Carro carro) {
        return carro;
    }
    @PutMapping(path = "/{id}")
    public Carro updateCarroById(@RequestBody Carro carro, @PathVariable("id") Integer id) {
        carro.setId(id);
        return carro;
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCarroById(@PathVariable("id") Integer id) {
        log.info("Deletando carro de id %s".formatted(id));
    }


}
