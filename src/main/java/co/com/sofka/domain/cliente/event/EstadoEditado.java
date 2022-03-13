package co.com.sofka.domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.reserva.valor.Estado;

public class EstadoEditado extends DomainEvent {
    private final Estado estado;

    public EstadoEditado(Estado estado) {
        super("cliente.editarestado");
        this.estado=estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
