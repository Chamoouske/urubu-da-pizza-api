package br.com.urubu.da.pizza.domain.usecases.state.pendencia;

import br.com.urubu.da.pizza.domain.enums.EstadosPendencia;
import br.com.urubu.da.pizza.domain.models.Pendencia;
import org.apache.kafka.common.security.oauthbearer.internals.secured.ValidateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EstadoTest {
    @Test
    void pagavelTest() {
        Pendencia pendencia = new Pendencia();

        pendencia.pagar();

        Assertions.assertEquals(EstadosPendencia.PAGA, pendencia.getEstado());
    }

    @Test
    void naoPagavelTest() {
        Pendencia pendencia = new Pendencia();
        pendencia.setEstado(EstadosPendencia.PAGA);

        Assertions.assertThrows(ValidateException.class, pendencia::pagar);
    }

    @Test
    void cancelavelTest() {
        Pendencia pendencia = new Pendencia();

        pendencia.cancelar();

        Assertions.assertEquals(EstadosPendencia.CANCELADA, pendencia.getEstado());
    }

    @Test
    void naoCancelavelTest() {
        Pendencia pendencia = new Pendencia();
        pendencia.setEstado(EstadosPendencia.CANCELADA);

        Assertions.assertThrows(ValidateException.class, pendencia::cancelar);
    }
}