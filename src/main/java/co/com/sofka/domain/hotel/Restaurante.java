package co.com.sofka.domain.hotel;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.hotel.valor.Location;
import co.com.sofka.domain.hotel.valor.Personal;
import co.com.sofka.domain.hotel.valor.RestauranteID;

public class Restaurante extends Entity<RestauranteID> {

    private Location location;


    public Restaurante(RestauranteID restauranteID,Location location) {
        super(restauranteID);
        this.location = location;
    }

    public void editarLocation(Location location){
        this.location = location;
    }
}
