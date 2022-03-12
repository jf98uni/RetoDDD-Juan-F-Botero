package co.com.sofka.domain.reserva.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.reserva.valor.Estado;

public class EstadoCambiado extends DomainEvent {
    private final Estado estado;

    public EstadoCambiado(Estado estado) {
        super("reserva.cambiarestado");

        this.estado = new Estado(Estado.Fase.Confirmado);
    }

    public Estado getEstado() {
        return estado;
    }
}
