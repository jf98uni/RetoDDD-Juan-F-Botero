package co.com.sofka.domain.hotel.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.hotel.Hotel;
import co.com.sofka.domain.hotel.command.CrearHotel;

public class CrearHotelUseCase extends UseCase<RequestCommand<CrearHotel>, ResponseEvents>  {

    @Override
    public void executeUseCase(RequestCommand<CrearHotel> CrearHotelRequestCommand) {
        var command = CrearHotelRequestCommand.getCommand();
        var hotel = new Hotel(command.getHotelID(),command.getDatosHotel());
        emit().onResponse(new ResponseEvents(hotel.getUncommittedChanges()));
    }

}
