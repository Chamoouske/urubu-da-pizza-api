package br.com.urubu.da.pizza.domain.models;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    UUID id;
    String nome;
    List<Pendencia> pendencias;
}
