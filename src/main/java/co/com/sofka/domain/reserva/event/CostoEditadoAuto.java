package co.com.sofka.domain.reserva.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.reserva.valor.Costo;
import co.com.sofka.domain.reserva.valor.FacturaID;

public class CostoEditado extends DomainEvent {
    private final Costo costo;

    public CostoEditado(Costo costo) {
        super("reserva.editarcosto");
        this.costo = costo;

    }

    public Costo getCosto() {
        return costo;
    }
}
