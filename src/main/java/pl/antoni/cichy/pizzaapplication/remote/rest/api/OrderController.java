package pl.mikolaj.pokora.pizzaapplication.remote.rest.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mikolaj.pokora.pizzaapplication.domain.model.OrderStatusType;
import pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.request.AddOrderDto;
import pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.response.OrderCollectionDto;
import pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.response.OrderStatusDto;
import pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.response.TokenDto;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "/api/v1/orders", produces = APPLICATION_JSON_VALUE)
@RestController
public class OrderController {








    @PostMapping
    public ResponseEntity<TokenDto> addOrder(@RequestBody AddOrderDto addOrderDto) {
        //TokenDto tokenDto = addOrderService.addOrder(addOrderDto);
        return ResponseEntity.ok(null);
    }


    @GetMapping("/status/{token}")
    public ResponseEntity<OrderStatusDto> getStatus(@PathVariable("token")String token) {
        //OrderStatusDto orderStatusDto = getOrderService.getOrderStatus(token);

        return ResponseEntity.ok(null);
    }



    @GetMapping
    public ResponseEntity<OrderCollectionDto> getOrders(@RequestParam("status") OrderStatusType orderStatus, @RequestHeader("Acces-Token") String token) {

        //OrderCollectionDto orderCollectionDto = getOrderService.getOrderByStatus(orderStatus, token);
        return ResponseEntity.ok(null);
    }


}
