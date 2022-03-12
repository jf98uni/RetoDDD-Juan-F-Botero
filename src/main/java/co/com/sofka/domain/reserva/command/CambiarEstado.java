package co.com.sofka.domain.reserva.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.reserva.valor.Costo;
import co.com.sofka.domain.reserva.valor.Estado;
import co.com.sofka.domain.reserva.valor.FacturaID;
import co.com.sofka.domain.reserva.valor.ReservaID;

public class CambiarEstado extends Command {

    private final Estado estado;

    public CambiarEstado(ReservaID reservaID, ReservaID reservaID1, FacturaID facturaID, Costo costo, Estado estado) {

        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
