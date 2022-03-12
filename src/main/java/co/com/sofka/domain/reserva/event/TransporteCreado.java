package co.com.sofka.domain.reserva.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.reserva.Transporte;
import co.com.sofka.domain.reserva.valor.Auto;
import co.com.sofka.domain.reserva.valor.Costo;
import co.com.sofka.domain.reserva.valor.TransporteID;

import java.lang.management.ThreadInfo;

public class TransporteCreado extends DomainEvent {

    private final TransporteID transporteID;
    private final Costo costo;
    private final Auto auto;
    public TransporteCreado(TransporteID transporteID, Costo costo, Auto auto) {
        super("reserva.creartransporte");
        this.auto = auto;
        this.costo = costo;
        this.transporteID = transporteID;
    }

    public TransporteID getTransporteID() {
        return transporteID;
    }

    public Costo getCosto() {
        return costo;
    }

    public Auto getAuto() {
        return auto;
    }
}
