package br.com.eadtt.aula01.controller;

import br.com.eadtt.aula01.Constants;
import br.com.eadtt.aula01.controller.request.CarroRequest;
import br.com.eadtt.aula01.controller.response.CarroResponse;
import br.com.eadtt.aula01.controller.response.CarroResponseList;
import br.com.eadtt.aula01.model.Carro;
import br.com.eadtt.aula01.service.CarroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(Constants.V0 + "/carros")
public class CarroController {
    // Injeção por field - @Autowired
    // @Autowired
    private final CarroService carroService;
    // Injeção por construtor - recomendado
    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    // O path no REST identifica o recurso, ou a api
    @GetMapping(produces = "application/json")
    public CarroResponseList getAllCarros(@RequestParam(name = "marca", required = false) String marca,
                                          @RequestParam(name = "modelo", required = false) String modelo ) {
        // Para multiplos filtros está bem ruim esse codigo, vamos mudar!
        List<Carro> allCarros;
        if(marca == null) {
            allCarros = carroService.getAllCarros();
        } else {
            allCarros = carroService.getCarrosByMarca(marca);
        }

        if(modelo != null) {
            allCarros = carroService.getCarrosByModelo(modelo);
        }

        List<CarroResponse> carroResponseList = allCarros.stream()
                .map(
                        carro -> new CarroResponse(carro.getId(), carro.getMarca(), carro.getModelo(), carro.getAno())
                ).toList();
        return new CarroResponseList(carroResponseList);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CarroResponse createNewCarro(@RequestBody CarroRequest request) {
        Carro carroRequest = new Carro(null, request.getMarca(), request.getModelo(), request.getAno());
        Carro carroSalvo = carroService.save(carroRequest);
        CarroResponse carroResponse = new CarroResponse(carroSalvo.getId(), carroRequest.getMarca(), carroRequest.getModelo(), carroRequest.getAno());
        return carroResponse;
    }

    @PutMapping(path = "/{id}")
    public CarroResponse updateCarroById(@RequestBody CarroRequest request, @PathVariable("id") Integer id) {
        Carro carroRequest = new Carro(id, request.getMarca(), request.getModelo(), request.getAno());
        Carro carroSalvo = carroService.save(carroRequest);
        CarroResponse carroResponse = new CarroResponse(carroSalvo.getId(), carroRequest.getMarca(), carroRequest.getModelo(), carroRequest.getAno());
        return carroResponse;
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCarroById(@PathVariable("id") Integer id) {
        log.info("Deletando carro de id %s".formatted(id));
        carroService.deleteById(id);
    }


}
