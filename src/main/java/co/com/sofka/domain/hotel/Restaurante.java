package co.com.sofka.domain.hotel;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.hotel.valor.Location;
import co.com.sofka.domain.hotel.valor.Personal;
import co.com.sofka.domain.hotel.valor.RestauranteID;
import java.util.Collections;

import java.util.List;

public class Restaurante extends Entity<RestauranteID> {

    private Location location;


    public Restaurante(RestauranteID restauranteID,Location location) {
        super(restauranteID);
        this.location = location;
    }

    public void editarLocation(Location location){
        this.location = location;
    }

    public List<DomainEvent> getUncommittedChanges() {
        return Collections.emptyList();
    }
}
