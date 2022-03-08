package co.com.sofka.domain.transporte.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.transporte.valor.OrdenId;
import co.com.sofka.domain.transporte.valor.TransporteId;

public class EntregarOrden extends Command {
    private final OrdenId ordenId;
    private final TransporteId transporteId;

    public EntregarOrden(OrdenId ordenId, TransporteId transporteId) {
        this.ordenId = ordenId;
        this.transporteId = transporteId;
    }

    public TransporteId getTransporteId() {
        return transporteId;
    }

    public OrdenId getOrdenId() {
        return ordenId;
    }
}
