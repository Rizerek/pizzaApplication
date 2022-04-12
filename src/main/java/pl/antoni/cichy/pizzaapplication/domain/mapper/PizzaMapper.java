package pl.mikolaj.pokora.pizzaapplication.domain.mapper;

import pl.mikolaj.pokora.pizzaapplication.data.entity.pizza.PizzaEntity;
import pl.mikolaj.pokora.pizzaapplication.data.entity.size.SizeEntity;
import pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.request.AddPizzaDto;
import pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.response.PizzaDto;
import pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.response.SizeDto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PizzaMapper {

    private final SizeMapper sizeMapper;

    public PizzaMapper(SizeMapper sizeMapper) {
        this.sizeMapper = sizeMapper;
    }



    public PizzaEntity mapToPizzaEntity(AddPizzaDto addPizzaDto) {
        PizzaEntity pizzaEntity = new PizzaEntity();
        pizzaDto.setName(pizzaEntity.getName());
        return null;
    }

    public PizzaDto mapToPizzaDto(PizzaEntity pizzaEntity, List<SizeDto> sizeDtoList) {
        return null;
    }

    public Object mapToPizzaDto(PizzaEntity pizzaEntity) {
        Set<SizeEntity> sizeEntitySet = pizzaEntity.getSizes();

        List<SizeDto> sizeDtoList = sizeEntitySet
                .stream()
                .map(sizeMapper::mapToSizeDto)
                .collect(Collectors.toList());
        return mapToPizzaDto(pizzaEntity, sizeDtoList);
    }
}
