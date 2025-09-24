package br.com.urubu.da.pizza.domain.models;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pizza {
    UUID id;
    BigDecimal preco;
    Integer quantidade;
    Usuario pagante;
    Usuario recebedor;
}
