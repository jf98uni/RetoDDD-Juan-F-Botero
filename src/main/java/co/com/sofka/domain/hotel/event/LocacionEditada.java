package co.com.sofka.domain.hotel.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.hotel.valor.Location;

import java.lang.management.ThreadInfo;

public class LocacionEditada extends DomainEvent {

    private final Location location;

    public LocacionEditada(Location location) {
        super("hotel.editarlocacion");
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
