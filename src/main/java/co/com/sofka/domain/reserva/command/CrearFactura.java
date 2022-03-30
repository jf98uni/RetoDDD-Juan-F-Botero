package co.com.sofka.domain.reserva.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.reserva.valor.Costo;
import co.com.sofka.domain.reserva.valor.FacturaID;
import co.com.sofka.domain.reserva.valor.ReservaID;

public class CrearFactura extends Command {
    private  final ReservaID reservaID1;
    private  final FacturaID facturaID1;
    private  final Costo costo1;

    public CrearFactura(ReservaID reservaID, FacturaID facturaID, Costo costo) {
        this.reservaID1 = reservaID;
        this.facturaID1 = facturaID;
        this.costo1 = costo;
    }

    public FacturaID getFacturaID() {
        return facturaID1;
    }

    public Costo getCosto() {
        return costo1;
    }

    public ReservaID getReservaID() {
        return reservaID1;
    }
}