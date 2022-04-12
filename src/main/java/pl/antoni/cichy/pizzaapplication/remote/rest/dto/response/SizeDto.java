package pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.mikolaj.pokora.pizzaapplication.domain.model.SizeType;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class SizeDto {

    private Integer id;
    private SizeType size;
    private BigDecimal price;

    public SizeDto(Integer id, SizeType size, BigDecimal price) {
        this.id = id;
        this.size = size;
        this.price = price;
    }
}