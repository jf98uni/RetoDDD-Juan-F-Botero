package co.com.sofka.domain.cliente.valor;

import co.com.sofka.domain.generic.ValueObject;

public class Estado implements ValueObject<co.com.sofka.domain.reserva.valor.Estado.Fase> {

    private final co.com.sofka.domain.reserva.valor.Estado.Fase value;

    public Estado(co.com.sofka.domain.reserva.valor.Estado.Fase value){
        this.value = value;
    }

    @Override
    public co.com.sofka.domain.reserva.valor.Estado.Fase value() {
        return value;
    }

    public enum Fase {
        Confirmado, no_Confirmado
    }
}
