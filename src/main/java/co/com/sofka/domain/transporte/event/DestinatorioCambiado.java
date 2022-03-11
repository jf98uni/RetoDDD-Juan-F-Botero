package co.com.sofka.domain.transporte.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.transporte.valor.Destinatario;
import co.com.sofka.domain.transporte.valor.OrdenId;

public class DestinatorioCambiado extends DomainEvent {
    private final OrdenId ordenId;
    private final Destinatario destinatario;

    public DestinatorioCambiado(OrdenId ordenId, Destinatario destinatario) {
        super("transporte.destinatoriocambiado");
        this.ordenId = ordenId;
        this.destinatario = destinatario;
    }

    public OrdenId getOrdenId() {
        return ordenId;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }
}
