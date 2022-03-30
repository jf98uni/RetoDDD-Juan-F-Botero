package co.com.sofka.domain.reserva.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.reserva.Factura;
import co.com.sofka.domain.reserva.Reserva;
import co.com.sofka.domain.reserva.Transporte;
import co.com.sofka.domain.reserva.command.CrearFactura;
import co.com.sofka.domain.reserva.command.CrearTransporte;

public class CrearTransporteUseCase extends UseCase<RequestCommand<CrearTransporte>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearTransporte> input) {
        var command = input.getCommand();

        var reserva = new Reserva(command.getReservaID());

        reserva.crearTransporte(command.getTransporteID(),command.getCosto(),command.getAuto());

        emit().onResponse(new ResponseEvents(reserva.getUncommittedChanges()));
    }
}
