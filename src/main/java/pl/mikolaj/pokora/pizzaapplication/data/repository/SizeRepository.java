package pl.mikolaj.pokora.pizzaapplication.data.repository;

import pl.mikolaj.pokora.pizzaapplication.data.entity.pizza.PizzaEntity;
import pl.mikolaj.pokora.pizzaapplication.data.entity.size.SizeEntity;

import java.util.List;

public interface SizeRepository {

    public default PizzaEntity saveAll(List<SizeEntity> sizeEntities) {

        return null;
    }
}
