package pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.List;

@Getter
@Setter
public class MenuDto {

    private List<PizzaDto> pizzas;

    public MenuDto() {
    }

    public MenuDto(List<PizzaDto> pizzas) { this.pizzas = pizzas; }
}