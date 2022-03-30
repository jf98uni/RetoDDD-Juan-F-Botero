package co.com.sofka.domain.reserva.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.reserva.valor.Costo;
import co.com.sofka.domain.reserva.valor.FacturaID;

public class CostoEditadoFactura extends DomainEvent {
    private final Costo costo;
    private final FacturaID facturaID;

    public CostoEditadoFactura(FacturaID facturaID, Costo costo) {
        super("reserva.editarcostofactura");
        this.facturaID = facturaID;
        this.costo = costo;

    }

    public Costo getCosto() {
        return costo;
    }

    public FacturaID getFacturaID() {
        return facturaID;
    }
}
