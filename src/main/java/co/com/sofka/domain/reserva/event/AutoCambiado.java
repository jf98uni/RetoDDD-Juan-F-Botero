package co.com.sofka.domain.reserva.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.reserva.valor.Auto;

public class AutoCambiado extends DomainEvent {
    public final Auto auto;

    public AutoCambiado(Auto auto) {
        super("reserva.cambiarauto");
        this.auto = auto;
    }

    public Auto getAuto() {
        return auto;
    }
}
