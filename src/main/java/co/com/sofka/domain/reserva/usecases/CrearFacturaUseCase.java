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
    public void executeUseCase(RequestCommand<CrearFactura> crearFacturaRequestCommand) {
        var command = crearFacturaRequestCommand.getCommand();
        var factura = new Factura(command.getFacturaID(),command.getCosto());
        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
