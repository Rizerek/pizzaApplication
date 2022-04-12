package pl.mikolaj.pokora.pizzaapplication.data.repository;

import pl.antoni.cichy.pizzaapplication.data.entity.pizza.PizzaEntity;
import pl.antoni.cichy.pizzaapplication.data.entity.size.SizeEntity;

import java.util.List;

public interface SizeRepository extends JpaRepository<SizeEntity,Integer>{

    void deleteAllByPizzaId(Integer pizzaId);

    boolean existsAllByIdIn(Set<Integer> ids)

}
