package co.com.sofka.domain.hotel.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.hotel.valor.Location;

public class EditarLocacion extends Command {
    private final Location location;

    public EditarLocacion(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
