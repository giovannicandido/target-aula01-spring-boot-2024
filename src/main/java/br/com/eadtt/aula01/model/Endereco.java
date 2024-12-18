package br.com.eadtt.aula01.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "endereco_seq", sequenceName = "endereco_seq")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_seq")
    private Integer id;
    private String logradouro;
    private Integer numero;
    private String bairro;
}
