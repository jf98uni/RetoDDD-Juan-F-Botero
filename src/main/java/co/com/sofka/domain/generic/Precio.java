package co.com.sofka.domain.generic;

import co.com.sofka.domain.generic.ValueObject;

public class Precio implements ValueObject<Double> {
    private final Double value;

    public Precio(Double value) {
        this.value = value;//TODO: validar
    }

    @Override
    public Double value() {
        return value;
    }
}
