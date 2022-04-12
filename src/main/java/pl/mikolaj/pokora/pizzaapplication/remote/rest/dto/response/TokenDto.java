package pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.response;

import lombok.Data;

@Data
public class TokenDto {
    private String token;

    public TokenDto() {}
    public TokenDto(String token) {
        this.token = token;
    }
}
