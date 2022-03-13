package co.com.sofka.domain.cliente.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Costo  implements ValueObject<Double> {
    private final Double costo;

    public Costo(Double costo){
        this.costo = Objects.requireNonNull(costo);
    }

    @Override
    public Double value() {
        return costo;
    }
}
