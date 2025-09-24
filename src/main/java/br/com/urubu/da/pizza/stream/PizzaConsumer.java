package br.com.urubu.da.pizza.stream;

import br.com.urubu.da.pizza.domain.models.Pizza;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class PizzaConsumer implements Consumer<Pizza> {
    @Override
    public void accept(Pizza pizza) {
        try {
            log.info("Receiving pizza: {}", pizza);
            log.info("Pizza saved successfully");
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
}
