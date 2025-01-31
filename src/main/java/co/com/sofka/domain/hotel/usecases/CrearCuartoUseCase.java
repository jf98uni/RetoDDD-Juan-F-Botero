package co.com.sofka.domain.hotel.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.hotel.Cuarto;
import co.com.sofka.domain.hotel.Hotel;
import co.com.sofka.domain.hotel.command.CrearCuarto;

public class CrearCuartoUseCase extends UseCase<RequestCommand<CrearCuarto>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CrearCuarto> CrearCuartoRequestCommand) {
        var command = CrearCuartoRequestCommand.getCommand();
       var hotel = new Hotel(command.getHotelID());

       hotel.crearCuarto(command.getCuartoID(), command.getPersonal());

        emit().onResponse(new ResponseEvents(hotel.getUncommittedChanges()));
        }
}
