package co.com.sofka.domain.reserva.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.reserva.valor.Costo;

public class CostoEditadoFactura extends DomainEvent {
    private final Costo costo;

    public CostoEditadoFactura(Costo costo) {
        super("reserva.editarcosto");
        this.costo = costo;

    }

    public Costo getCosto() {
        return costo;
    }
}
