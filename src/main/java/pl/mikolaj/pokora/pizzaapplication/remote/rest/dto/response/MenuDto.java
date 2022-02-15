package pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.response;

import pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.response.PizzaDto;

import java.util.List;

public class MenuDto {

    private List<PizzaDto> pizzas;

    public MenuDto() {
    }

    public MenuDto(List<PizzaDto> pizzas) { this.pizzas = pizzas; }

    public List<PizzaDto> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<PizzaDto> pizzas) {
        this.pizzas = pizzas;
    }
}