package co.com.sofka.domain.cliente.event;

import co.com.sofka.domain.cliente.valor.Tarjeta;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.reserva.valor.Estado;

public class CompraRealizada extends DomainEvent {

    private final Tarjeta tarjeta;
    private final Estado estado;

    public CompraRealizada(Tarjeta tarjeta, Estado estado) {
        super("cliente.realizarcompra");
        this.tarjeta = tarjeta;
        this.estado = estado;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public Estado getEstado() {
        return estado;
    }
}
