package co.com.sofka.domain.transporte.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.transporte.valor.OrdenId;

public class OrdenEntregada extends DomainEvent {
    private final OrdenId ordenId;

    public OrdenEntregada(OrdenId ordenId) {
        super("transporte.entregarorden");
        this.ordenId = ordenId;
    }

    public OrdenId getOrdenId() {
        return ordenId;
    }
}
