package pl.antoni.cichy.pizzaapplication.data.repository;

import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;

import

public interface OrderRepository extends JpaRepository<OrderSizeEntity, Integer> {
}
