package br.com.eadtt.aula01.controller;

import br.com.eadtt.aula01.Constants;
import br.com.eadtt.aula01.controller.request.DeleteOficinaFilterRequest;
import br.com.eadtt.aula01.controller.request.OficinaRequest;
import br.com.eadtt.aula01.controller.response.OficinaResponse;
import br.com.eadtt.aula01.controller.response.OficinaResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.V0 + "/oficinas")
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
}
