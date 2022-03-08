package co.com.sofka.domain.pedido.value;

import co.com.sofka.domain.generic.ValueObject;

public class PrecioNeto implements ValueObject<Double> {
    private final Double value;

    public PrecioNeto(Double value) {
        this.value = value;//TODO: validar
    }

    @Override
    public Double value() {
        return value;
    }
}
