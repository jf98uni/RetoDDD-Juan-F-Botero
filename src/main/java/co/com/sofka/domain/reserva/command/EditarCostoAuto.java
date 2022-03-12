package co.com.sofka.domain.reserva.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.reserva.Reserva;
import co.com.sofka.domain.reserva.valor.Costo;
import co.com.sofka.domain.reserva.valor.ReservaID;

public class EditarCosto extends Command {

    private  final ReservaID reservaID;
    private final Costo costo;

    public EditarCosto(ReservaID reservaID,Costo costo) {
        this.costo = costo;
        this.reservaID = reservaID;
    }

    public Costo getCosto() {
        return costo;
    }

    public ReservaID getReservaID() {
        return reservaID;
    }
}
