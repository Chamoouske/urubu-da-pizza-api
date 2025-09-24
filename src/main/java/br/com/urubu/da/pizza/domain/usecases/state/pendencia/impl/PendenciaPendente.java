package br.com.urubu.da.pizza.domain.usecases.state.pendencia.impl;

import br.com.urubu.da.pizza.domain.enums.EstadosPendencia;
import br.com.urubu.da.pizza.domain.models.Pendencia;
import br.com.urubu.da.pizza.domain.usecases.state.pendencia.Estado;

public class PendenciaPendente implements Estado {
    @Override
    public void pagar(Pendencia pendencia) {
        pendencia.setEstado(EstadosPendencia.PAGA);
    }

    @Override
    public void cancelar(Pendencia pendencia) {
        pendencia.setEstado(EstadosPendencia.CANCELADA);
    }
}
