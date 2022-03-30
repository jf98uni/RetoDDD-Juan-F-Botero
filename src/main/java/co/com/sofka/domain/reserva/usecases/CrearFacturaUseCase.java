package co.com.sofka.domain.reserva.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.reserva.Factura;
import co.com.sofka.domain.reserva.Reserva;
import co.com.sofka.domain.reserva.command.CrearFactura;
import co.com.sofka.domain.reserva.command.CrearReserva;

public class CrearFacturaUseCase extends UseCase<RequestCommand<CrearFactura>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearFactura> input) {
        var command =  input.getCommand();

        var reserva = new Reserva(command.getReservaID());

        reserva.crearFactura(command.getFacturaID(), command.getCosto());

        emit().onResponse(new ResponseEvents(reserva.getUncommittedChanges()));
    }
}
