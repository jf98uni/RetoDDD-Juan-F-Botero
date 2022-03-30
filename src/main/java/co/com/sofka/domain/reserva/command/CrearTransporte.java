package co.com.sofka.domain.reserva.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.reserva.Reserva;
import co.com.sofka.domain.reserva.valor.Auto;
import co.com.sofka.domain.reserva.valor.Costo;
import co.com.sofka.domain.reserva.valor.ReservaID;
import co.com.sofka.domain.reserva.valor.TransporteID;

public class CrearTransporte extends Command {
    private final ReservaID reservaID;
    private  final Auto auto;
    private final TransporteID transporteID;
    private final Costo costo;

    public CrearTransporte(ReservaID reservaID, TransporteID transporteID, Costo costo, Auto auto) {

        this.reservaID = reservaID;
        this.auto = auto;
        this.transporteID = transporteID;
        this.costo = costo;
    }

    public ReservaID getReservaID() {
        return reservaID;
    }

    public Costo getCosto() {
        return costo;
    }

    public Auto getAuto() {
        return auto;
    }

    public TransporteID getTransporteID() {
        return transporteID;
    }
}
