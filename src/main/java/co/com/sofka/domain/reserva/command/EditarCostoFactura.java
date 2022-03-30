package co.com.sofka.domain.reserva.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.reserva.Reserva;
import co.com.sofka.domain.reserva.valor.Costo;
import co.com.sofka.domain.reserva.valor.FacturaID;
import co.com.sofka.domain.reserva.valor.ReservaID;

public class EditarCostoFactura extends Command {


    private final FacturaID facturaID;
    private final Costo costo;

    public EditarCostoFactura(FacturaID facturaID,Costo costo) {
        this.costo = costo;
        this.facturaID = facturaID;
    }

    public Costo getCosto() {
        return costo;
    }

    public FacturaID getFacturaID() {
        return facturaID;
    }
}
