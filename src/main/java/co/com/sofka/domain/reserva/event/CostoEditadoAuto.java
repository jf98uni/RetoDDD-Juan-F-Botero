package co.com.sofka.domain.reserva.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.reserva.valor.Costo;

public class CostoEditadoAuto extends DomainEvent {
    private final Costo costo;

    public CostoEditadoAuto(Costo costo) {
        super("reserva.editarcostoauto");
        this.costo = costo;

    }

    public Costo getCosto() {
        return costo;
    }
}
