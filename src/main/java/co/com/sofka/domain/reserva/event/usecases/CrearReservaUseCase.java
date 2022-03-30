package co.com.sofka.domain.reserva.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.reserva.Reserva;
import co.com.sofka.domain.reserva.command.CrearReserva;

public class CrearReservaUseCase extends UseCase<RequestCommand<CrearReserva>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearReserva> crearReservaRequestCommand) {
        var command = crearReservaRequestCommand.getCommand();
        var reserva = new Reserva(command.getReservaID(),command.getClienteID(),command.getHotelID(),command.getEstado());
        emit().onResponse(new ResponseEvents(reserva.getUncommittedChanges()));
    }


}
