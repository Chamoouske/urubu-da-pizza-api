package br.com.urubu.da.pizza.domain.enums;

import br.com.urubu.da.pizza.domain.models.Pendencia;
import br.com.urubu.da.pizza.domain.usecases.state.pendencia.Estado;
import br.com.urubu.da.pizza.domain.usecases.state.pendencia.impl.PendenciaCancelada;
import br.com.urubu.da.pizza.domain.usecases.state.pendencia.impl.PendenciaPaga;
import br.com.urubu.da.pizza.domain.usecases.state.pendencia.impl.PendenciaPendente;

public enum EstadosPendencia {
    PENDENTE(new PendenciaPendente()),
    PAGA(new PendenciaPaga()),
    CANCELADA(new PendenciaCancelada());

    private final Estado estado;

    EstadosPendencia(Estado estado) {
        this.estado = estado;
    }

    public void pagar(Pendencia pendencia) {
        estado.pagar(pendencia);
    }

    public void cancelar(Pendencia pendencia) {
        estado.cancelar(pendencia);
    }
}
