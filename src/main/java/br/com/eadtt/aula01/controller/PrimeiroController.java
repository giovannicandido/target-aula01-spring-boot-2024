package br.com.eadtt.aula01.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PrimeiroController {

    @GetMapping(path = "/", produces = "application/json")
    public Carro hello() {
        return new Carro(1, "Ford", "Focus", 2019);
    }

    @PostMapping(path = "/")
    public Carro helloCarro(@RequestBody Carro carro) {
        return carro;
    }
    // /1/hello
    @PutMapping(path = "/{id}")
    public Carro helloCarroPut(@RequestBody Carro carro, @PathVariable("id") Integer id) {
        carro.setId(id);
        return carro;
    }

    @DeleteMapping(path = "/{id}")
    public void helloCarroDelete(@PathVariable("id") Integer id) {
        log.info("Deletando carro de id %s".formatted(id));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Carro {
        private Integer id;
        private String marca;
        private String modelo;
        private Integer ano;

    }
}
