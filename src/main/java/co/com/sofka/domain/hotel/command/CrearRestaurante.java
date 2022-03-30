package co.com.sofka.domain.hotel.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.hotel.valor.HotelID;
import co.com.sofka.domain.hotel.valor.Location;
import co.com.sofka.domain.hotel.valor.RestauranteID;

public class CrearRestaurante extends Command {
    private final HotelID hotelID;
    private final RestauranteID restauranteID;
    private final Location location;

    public CrearRestaurante(HotelID hotelID, RestauranteID restauranteID, Location location) {
        this.restauranteID = restauranteID;
        this.location = location;
        this.hotelID = hotelID;
    }

    public RestauranteID getRestauranteID() {
        return restauranteID;
    }

    public Location getLocation() {
        return location;
    }

    public HotelID getHotelID() {
        return hotelID;
    }
}
