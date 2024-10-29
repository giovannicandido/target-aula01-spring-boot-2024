package br.com.eadtt.aula01.controller.response;

import br.com.eadtt.aula01.model.Carro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroResponse {
    private Integer id;
    private String marca;
    private String modelo;
    private Integer ano;

    public static CarroResponse fromModel(Carro carro) {
        return new CarroResponse(carro.getId(), carro.getMarca(), carro.getModelo(), carro.getAno());
    }
}
