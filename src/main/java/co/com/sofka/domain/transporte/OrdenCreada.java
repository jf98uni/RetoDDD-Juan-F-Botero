package co.com.sofka.domain.transporte;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.transporte.valor.Destinatario;
import co.com.sofka.domain.transporte.valor.OrdenId;
import co.com.sofka.domain.transporte.valor.Remitente;

public class OrdenCreada extends DomainEvent {
    private final OrdenId ordenId;
    private final Remitente remitente;
    private final Destinatario destinatario;

    public OrdenCreada(OrdenId ordenId, Remitente remitente, Destinatario destinatario) {
        super("transporte.ordencreada");
        this.ordenId = ordenId;
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public OrdenId getOrdenId() {
        return ordenId;
    }

    public Remitente getRemitente() {
        return remitente;
    }
}
