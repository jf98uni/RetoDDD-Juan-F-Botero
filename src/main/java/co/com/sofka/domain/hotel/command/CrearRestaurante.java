package co.com.sofka.domain.hotel.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.hotel.valor.Location;
import co.com.sofka.domain.hotel.valor.RestauranteID;

public class CrearRestaurante extends Command {
    private final RestauranteID restauranteID;
    private final Location location;

    public CrearRestaurante(RestauranteID restauranteID, Location location) {
        this.restauranteID = restauranteID;
        this.location = location;
    }

    public RestauranteID getRestauranteID() {
        return restauranteID;
    }

    public Location getLocation() {
        return location;
    }
}
