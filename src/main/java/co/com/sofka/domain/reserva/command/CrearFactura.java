package co.com.sofka.domain.reserva.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.reserva.valor.Costo;
import co.com.sofka.domain.reserva.valor.FacturaID;
import co.com.sofka.domain.reserva.valor.ReservaID;

public class CrearFactura extends Command {
    private final ReservaID reservaID;
    private  final FacturaID facturaID;
    private  final Costo costo;
    public CrearFactura(ReservaID reservaID, ReservaID reservaID1, FacturaID facturaID, Costo costo) {
        this.reservaID = reservaID1;
        this.facturaID = facturaID;
        this.costo = costo;
    }

    public FacturaID getFacturaID() {
        return facturaID;
    }

    public Costo getCosto() {
        return costo;
    }

    public ReservaID getReservaID() {
        return reservaID;
    }
}