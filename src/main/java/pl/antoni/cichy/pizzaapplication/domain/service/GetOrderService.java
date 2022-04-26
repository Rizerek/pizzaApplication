package pl.antoni.cichy.pizzaapplication.domain.service;


import org.springframework.stereotype.Service;
import pl.mikolaj.pokora.pizzaapplication.domain.exception.UnauthorizedException;

@Service
public class GetOrderService {
    public OrderStatusDto getOrderStatus(String token)
    {
        OrderEntity orderEntity = orderRepository.findByToken();
        if(orderEntity==null)
        {
            throw new UnauthorizedException("Brak dostępu");
        }
        return orderMapper.mapToOrderStatusDto(orderEntity);
    }
}
