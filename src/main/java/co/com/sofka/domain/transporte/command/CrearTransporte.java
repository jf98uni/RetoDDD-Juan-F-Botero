package co.com.sofka.domain.transporte.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.transporte.valor.ConductorId;
import co.com.sofka.domain.transporte.valor.TransporteId;

public class CrearTransporte extends Command {
    private final TransporteId transporteId;
    private final ConductorId conductorId;

    public CrearTransporte(TransporteId transporteId, ConductorId conductorId) {
        this.transporteId = transporteId;
        this.conductorId = conductorId;
    }

    public ConductorId getConductorId() {
        return conductorId;
    }

    public TransporteId getTransporteId() {
        return transporteId;
    }
}
