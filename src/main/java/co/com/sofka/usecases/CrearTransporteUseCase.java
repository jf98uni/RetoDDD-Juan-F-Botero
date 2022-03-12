package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearTransporteUseCase extends UseCase<RequestCommand<CrearTransporte>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearTransporte> input) {
        var command = input.getCommand();
        //aplicar reglas de negocio
        var transporte = new Reserva(command.getTransporteId(), command.getConductorId());
        emit().onResponse(new ResponseEvents(transporte.getUncommittedChanges()));
    }
}
