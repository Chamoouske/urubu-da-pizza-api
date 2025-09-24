package br.com.urubu.da.pizza.domain.usecases;

import br.com.urubu.da.pizza.domain.models.Pendencia;
import br.com.urubu.da.pizza.domain.models.Usuario;

@FunctionalInterface
public interface AdicionarPendencia {
    Pendencia adicionar(Usuario devedor, Usuario recebedor);
}
