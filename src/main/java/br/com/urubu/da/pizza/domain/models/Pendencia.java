package br.com.urubu.da.pizza.domain.models;

import br.com.urubu.da.pizza.domain.enums.EstadosPendencia;
import lombok.*;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pendencia {
    UUID id;
    Usuario devedor;
    Usuario recebedor;
    @Setter
    EstadosPendencia estado = EstadosPendencia.PENDENTE;

    public void pagar() {
        estado.pagar(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }
}
