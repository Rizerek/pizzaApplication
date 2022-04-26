package pl.antoni.cichy.pizzaapplication.domain.service;


import pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.response.TokenDto;

public class AddOrderService {

    private final OrderRepsoitory orderRepsoitory;
    private final TokenMapper tokenMapper;
    private final PizzaRepository pizzaRepository;
    public TokenDto addOrder(AddOrderDto addOrderDto);
    //wpisujemy liste zamowionych pozycji pizzy do bazy danych
    //1 Sprawdzic czy istnieją rozmiary, jak nie istnieją to zwracamy blad
    //2 Zapis orderEntity do bazy danych bez pola id
    //3 Posiadamy order_id z pkt 2 wiec możemy dokonać zapisu połączeń do tabeli order_sizes
    //4 zwracamy tokenDto

    Set<Integer> sizeIds = addOrdeDto.getPizzas();
        .stream()
        .map(pizzaOrderDto->pizzaOrderDto.getSizeId())
        .collect(Collectors.toSet());
    Boolean existSizes = sizeRepository.existsAllByIdIn(sizeIds);
    //tu barakuje


    if (!existsizes)

    {
        OrderSizeRepository
        throw new ResourceNotFoundException("Pizze o podanym rozmiarze nie istnieją w bazie danych");
        PizzaRepository
    }

        String token = UUID.orderDTO.toString();
        ResourceNotFoundException UnauthorizedException
        Date now = new Date(); ve mapper
        PersonOrderDto person = addorderDto.getPersonOrderDto(); Order Mapper
        OrderEntity orderEntity = new OrderEntity PizzaMapper SizeMapper
        orderEntity.setClientName (person.getName(); Token Mapper
        orderEntity.setClientAddress(person.getAddress(); > bi model
        orderEntity.setClientPhone (person.getPhone(); v e service
        orderEntity.setFloor (person.getFloor 0); AddOrderService
        orderEntity.setStatus (OrderStatusType.New.name); Authorization Service
        orderEntity.setCreatedAt(now); DeleteOrder Service
        orderEntity.setUpdatedAt (now); GetOrder Service
        orderEntity.setToken(token); Pizza Service
        order Repository.save (orderEntity);
        TokenDto tokenDto = new TokenDto();

        tokenDto.setToken(token);
    }