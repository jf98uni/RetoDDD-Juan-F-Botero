package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.reserva.Factura;
import co.com.sofka.domain.reserva.Transporte;
import co.com.sofka.domain.reserva.command.CrearFactura;
import co.com.sofka.domain.reserva.command.CrearTransporte;

public class CrearTransporteUseCase extends UseCase<RequestCommand<CrearTransporte>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearTransporte> crearTransporteRequestCommand) {
        var command = crearTransporteRequestCommand.getCommand();
        var transporte = new Transporte(command.getTransporteID(),command.getCosto(),command.getAuto());
        emit().onResponse(new ResponseEvents(transporte.getUncommittedChanges()));
    }
}
