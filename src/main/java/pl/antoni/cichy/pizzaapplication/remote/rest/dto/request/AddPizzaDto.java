package pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AddPizzaDto {
    private String name;
    @JsonProperty("sizes")
    private List<AddSizeDto> addSizeDtoList;


    public AddPizzaDto(){}

    public AddPizzaDto(String name, List<AddSizeDto> addSizes) {
        this.name = name;
        addSizeDtoList = addSizes;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AddSizeDto> getAddSizeDtoList() {
        return addSizeDtoList;
    }

    public void setAddSizeDtoList(List<AddSizeDto> addSizeDtoList) {
        this.addSizeDtoList = addSizeDtoList;
    }
}
