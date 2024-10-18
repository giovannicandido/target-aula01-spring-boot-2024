package br.com.eadtt.aula01.repository.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarroOficina {
    private String marca;
    private String oficina;

    public CarroOficina(String marca, String oficina) {
        this.marca = marca;
        this.oficina = oficina;
    }
}
