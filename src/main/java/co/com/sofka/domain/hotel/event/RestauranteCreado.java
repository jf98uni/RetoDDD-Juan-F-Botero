package co.com.sofka.domain.hotel.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.hotel.Restaurante;
import co.com.sofka.domain.hotel.valor.Location;
import co.com.sofka.domain.hotel.valor.Personal;
import co.com.sofka.domain.hotel.valor.RestauranteID;

import java.util.PrimitiveIterator;

public class RestauranteCreado extends DomainEvent {
    private final RestauranteID restauranteID;
    private final Location location;

    public RestauranteCreado(RestauranteID restauranteID, Location location) {
        super("hotel.crearRestaurante");
        this.location = location;
        this.restauranteID = restauranteID;
    }

    public RestauranteID getRestauranteID() {
        return restauranteID;
    }

    public Location getLocation() {
        return location;
    }
}
