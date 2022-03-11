package co.com.sofka.domain.transporte.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.transporte.valor.Destinatario;
import co.com.sofka.domain.transporte.valor.OrdenId;
import co.com.sofka.domain.transporte.valor.TransporteId;

public class CambiarDestinatario extends Command {

    private final TransporteId transporteId;
    private final OrdenId ordenId;
    private final Destinatario destinatario;


    public CambiarDestinatario(TransporteId transporteId, OrdenId ordenId, Destinatario destinatario) {
        this.transporteId = transporteId;
        this.ordenId = ordenId;
        this.destinatario = destinatario;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public OrdenId getOrdenId() {
        return ordenId;
    }

    public TransporteId getTransporteId() {
        return transporteId;
    }
}
