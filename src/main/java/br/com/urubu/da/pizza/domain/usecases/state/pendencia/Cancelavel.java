package br.com.urubu.da.pizza.domain.usecases.state.pendencia;

import br.com.urubu.da.pizza.domain.models.Pendencia;
import org.apache.kafka.common.security.oauthbearer.internals.secured.ValidateException;

public interface Cancelavel {
    default void cancelar(Pendencia pendencia) {
        throw new ValidateException("A pendência não pode ser cancelada");
    }
}
