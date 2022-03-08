package co.com.sofka.domain.pedido.value;

import co.com.sofka.domain.generic.ValueObject;

public class PrecioPedido implements ValueObject<Double> {
    private final Double value;


    public PrecioPedido(Double value) {
        //TODO: validar
        this.value = value;
    }

    @Override
    public Double value() {
        return value;
    }
}
