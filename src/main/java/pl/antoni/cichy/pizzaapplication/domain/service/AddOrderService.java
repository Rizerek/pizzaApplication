package pl.mikolaj.pokora.pizzaapplication.domain.service;



public class AddOrderService {

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
}