package co.com.sofka.domain.hotel.valor;

import co.com.sofka.domain.generic.ValueObject;

public class Location implements ValueObject<String> {

    private final String location;

    public Location(String location) {
        this.location = location;
    }


    @Override
    public String value() {
        return location;
    }
}
