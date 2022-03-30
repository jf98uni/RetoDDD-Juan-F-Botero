package co.com.sofka.domain.reserva.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.reserva.valor.Costo;
import co.com.sofka.domain.reserva.valor.FacturaID;

public class FacturaCreada extends DomainEvent {

    private final FacturaID facturaID;
    private final Costo costo;

    public FacturaCreada(FacturaID facturaID, Costo costo) {
        super("reserva.crearfactura");
        this.costo = costo;
        this.facturaID = facturaID;
    }

    public FacturaID getFacturaID() {
        return facturaID;
    }

    public Costo getCosto() {
        return costo;
    }
}
