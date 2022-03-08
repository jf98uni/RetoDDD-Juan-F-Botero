package co.com.sofka.domain.pedido.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CantidadPedida implements ValueObject<Integer> {
    private final Integer value;

    public CantidadPedida(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(value <= 0){
            throw new IllegalArgumentException("No es valido el valor");
        }
    }

    public Integer value() {
        return value;
    }
}
