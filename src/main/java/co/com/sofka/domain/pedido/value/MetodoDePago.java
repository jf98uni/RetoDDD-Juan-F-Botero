package co.com.sofka.domain.pedido.value;

import co.com.sofka.domain.generic.ValueObject;

public class MetodoDePago implements ValueObject<String> {
    private final String value;

    public MetodoDePago(String value) {
        this.value = value;//TODO: agregar validaciones o reglas de dominio
    }

    @Override
    public String value() {
        return value;
    }
}
