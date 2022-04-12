package pl.mikolaj.pokora.pizzaapplication.domain.exception;

public class UnauthorizedException extends RuntimeException{

    public UnauthorizedException(String message) { super(message); }
}
