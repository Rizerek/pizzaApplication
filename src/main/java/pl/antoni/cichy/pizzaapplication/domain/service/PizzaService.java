package pl.antoni.cichy.pizzaapplication.domain.service;

import org.springframework.stereotype.Service;
import pl.antoni.cichy.pizzaapplication.data.entity.pizza.PizzaEntity;
import pl.antoni.cichy.pizzaapplication.data.entity.size.SizeEntity;
import pl.antoni.cichy.pizzaapplication.data.repository.SizeRepository;
import pl.antoni.cichy.pizzaapplication.domain.mapper.PizzaMapper;
import pl.antoni.cichy.pizzaapplication.domain.model.SizeType;
import pl.antoni.cichy.pizzaapplication.remote.rest.dto.request.AddPizzaDto;
import pl.antoni.cichy.pizzaapplication.remote.rest.dto.request.AddSizeDto;
import pl.antoni.cichy.pizzaapplication.remote.rest.dto.request.UpdatePizzaDto;
import pl.antoni.cichy.pizzaapplication.remote.rest.dto.response.MenuDto;
import pl.antoni.cichy.pizzaapplication.remote.rest.dto.response.PizzaDto;
import pl.antoni.cichy.pizzaapplication.data.repository.PizzaRepository;
import pl.antoni.cichy.pizzaapplication.domain.mapper.SizeMapper;
import pl.antoni.cichy.pizzaapplication.remote.rest.dto.response.SizeDto;

import java.util.List;
import java.util.stream.Collectors;

import static pl.mikolaj.pokora.pizzaapplication.domain.service.AuthorizationService.checkToken;

@Service
public class PizzaService {


    private final PizzaRepository pizzaRepository;
    private final SizeRepository sizeRepository;
    private final PizzaMapper pizzaMapper;
    private final SizeMapper sizeMapper;

    public PizzaService(PizzaRepository pizzaRepository, SizeRepository sizeRepository, PizzaMapper pizzaMapper, SizeMapper sizeMapper) {
        this.pizzaRepository = pizzaRepository;
        this.sizeRepository = sizeRepository;
        this.pizzaMapper = pizzaMapper;
        this.sizeMapper = sizeMapper;
    }

    public PizzaDto addPizza(AddPizzaDto addPizzaDto, String token) {

        checkToken(token);

        PizzaEntity pizzaEntity = pizzaMapper.mapToPizzaEntity(addPizzaDto);
        pizzaRepository.save(pizzaEntity);

        /*
        List<AddSizeDto> addSizeDtoList = addPizzaDto.getAddSizeDtoList();
        List<SizeEntity> sizeEntities = addSizeDtoList
                .stream()
                .map(addSizeDto -> {
                    SizeEntity sizeEntity = new SizeEntity();
                    SizeEntity.setSizeType(sizeDto.getSize().name());
                    SizeEntity.setPriceBase(sizeDto.getPrice());
                    sizeEntity.setId(sizeDto.getId());
                    sizeEntity.setPizzaId(savedPizzaEntity.getId());
                    return sizeEntity;
                }).collect(Collectors.toList());
        PizzaEntity savedSizeEntity = sizeRepository.saveAll(sizeEntity);
        */

        List<AddSizeDto> addSizeDtoList = addPizzaDto.getAddSizeDtoList();
        List<SizeEntity> sizeEntities = addSizeDtoList
                .stream()
                .map(addSizeDto -> sizeMapper.mapToSizeEntity(addSizeDto, pizzaEntity.getId()))
                .collect(Collectors.toList());
        PizzaEntity savedSizeEntities = sizeRepository.saveAll(sizeEntities);

        /*
        List<SizeDto> sizeDtoList = savedSizeEntities
                .stream()
                .map(sizeEntity -> {
                    SizeDto sizeDto = new SizeDto();
                    sizeDto.setSize(SizeType.volueOf(sizeEntity.getSizeType()));
                    sizeDto.setPrice(sizeEntity.getPriceBase());
                    sizeDto.setId(sizeEntity.getId());
                    return sizeDto;
                }).collect(Collectors.toList());
        */

        List<SizeDto> sizeDtoList = sizeEntities.stream()
                .map(sizeMapper::mapToSizeDto)
                .collect(Collectors.toList());

        List<SizeDto> sizeDtoList = SizeEntities.stream()
                .map(sizeEntity -> {
                    SizeDto sizeDto = new SizeDto();
                    sizeDto.setSize(SizeType.volueOf(sizeEntity.getSizeType()));
                    sizeDto.setPrice(sizeEntity.getPriceBase());
                    sizeDto.setId(sizeEntity.getId());
                    return sizeDto;
                }).collect(Collectors.toList());

        //PizzaEntity pizzaEntity = new PizzaEntity();
        //pizzaEntity.setName(addPizzaDto.getName());
        //PizzaEntity savedPizzaEntity = pizzaRepository.save(pizzaEntity);

        return pizzaMapper.mapToPizzaDto(pizzaEntity, sizeDtoList);
    }

    public PizzaDto updatePizza(UpdatePizzaDto updatePizzaDto, String token, Integer pizzaId) {
        checkToken(token);
        boolean pizzaExists = pizzaRepository.existsById(pizzaId);
        if (!pizzaExists) {
           throw new ResourceNotFoundException("Pizza o podanym id nie istnieje");
        }
        PizzaEntity pizzaEntity = pizzaRepository.getById(pizzaId);
        pizzaEntity.setName(updatePizzaDto.getName());
        pizzaRepository.save(pizzaEntity);

        sizeRepository.deleteAllByPizzaId(pizzaId);

        List<AddSizeDto> addSizeDtoList = updatePizzaDto.getSizes();
        List<SizeEntity> sizeEntities = addSizeDtoList;
            .stream()
            .map(addSizeDto -> sizeMapper.mapToSizeEntity(addSizeDto, pizzaId))
            .collect(Collectors.toList());
        sizeRepository.saveAll(sizeEntities);

        return pizzaMapper.mapToPizzaDto(pizzaEntity, sizeDtoList);

    }

    PizzaDto pizzaDto = mapToPizzaDto(pizzaEntity, sizeDtoList);
    return pizzaMapper.mapToPizzaDto(pizzaEntity, sizeDtoList);

    public MenuDto getMenu() {
        List<PizzaEntity> pizzaEntities = pizzaRepository.findAll();
        List<PizzaDto> pizzaDtoList = pizzaEntities
                .stream()
                .map(pizzaEntity -> pizzaMapper.mapToPizzaDto(pizzaEntity))
                .collect(Collectors.toList());
    }
    public void deletePizza(Integer pizzaId,String token)
    {
        //  if(token ==null||!token.equals("xzv"))
        //  {
        //      throw new UnauthorizedException("Bledny token");
        //  }
        check(token);
        boolean pizzaExist = pizzaRepository.existsById(pizzaId);
        if(!pizzaExist)
        {
            throw new ResourceNotFoundException("Pizza o podanym id nie istnieje");
        }
        List<SizeDto> sizeDtoList = sizeEntities.stream()
                .map(sizeMapper::mapToSizeDto)
                .collect(Collectors.toList());
        pizzaRepository.deleteById(pizzaId);
    }
}
