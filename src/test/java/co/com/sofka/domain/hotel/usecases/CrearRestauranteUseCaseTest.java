package co.com.sofka.domain.hotel.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.hotel.command.CrearCuarto;
import co.com.sofka.domain.hotel.command.CrearRestaurante;
import co.com.sofka.domain.hotel.event.CuartoCreado;
import co.com.sofka.domain.hotel.event.RestauranteCreado;
import co.com.sofka.domain.hotel.valor.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearRestauranteUseCaseTest {

    @Test
    public void crearRestaurante(){
        HotelID hotelID = new HotelID();
        RestauranteID restauranteID = new RestauranteID();
        Location location = new Location("ala sur");

        var command = new CrearRestaurante(hotelID,restauranteID,location);
        var usecase = new CrearRestauranteUseCase();
        // act

        var events = UseCaseHandler.getInstance().setIdentifyExecutor(restauranteID.value())
                .syncExecutor(usecase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //assert
        var event =(RestauranteCreado)events.get(0);
        Assertions.assertEquals("hotel.crearrestaurante",event.type);
        Assertions.assertEquals("ala sur",event.getLocation().value());
        Assertions.assertEquals(hotelID.value(),event.aggregateRootId());

    }

}