package co.com.sofka.domain.hotel.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.hotel.Hotel;
import co.com.sofka.domain.hotel.Restaurante;
import co.com.sofka.domain.hotel.command.CrearHotel;
import co.com.sofka.domain.hotel.command.CrearRestaurante;
import co.com.sofka.domain.reserva.Reserva;

public class CrearRestauranteUseCase extends UseCase<RequestCommand<CrearRestaurante>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearRestaurante> crearRestauranteRequestCommand) {
        var command = crearRestauranteRequestCommand.getCommand();
        var restaurante = new Restaurante(command.getRestauranteID(),command.getLocation());
        emit().onResponse(new ResponseEvents(restaurante.getUncommittedChanges()));
    }
}
