package pl.mikolaj.pokora.pizzaapplication.data.entity.size;


import lombok.Data;
import lombok.NoArgsConstructor;
import pl.mikolaj.pokora.pizzaapplication.data.entity.ordersize.OrderSizeEntity;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;
import pl.mikolaj.pokora.pizzaapplication.data.entity.pizza.PizzaEntity;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sizes")
public class SizeEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "size_type")
    private String sizeType;


    @Column(name = "price_base")
    private BigDecimal priceBase;


    @Column(name = "pizza_id")
    private Integer pizzaId;


    @OneToMany(mappedBy = "size")
    private Set<OrderSizeEntity> orderSizes;

    @ManyToOne()
    @JoinColumn(name = "pizza_id", insertable = false, updatable = false)
    private PizzaEntity pizza;
}
