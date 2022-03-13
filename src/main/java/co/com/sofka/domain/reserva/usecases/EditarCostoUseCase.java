package co.com.sofka.domain.reserva.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.reserva.command.EditarCostoAuto;
import co.com.sofka.domain.reserva.valor.Costo;

public class EditarCostoUseCase extends UseCase<RequestCommand<EditarCostoAuto>, ResponseEvents>  {


    @Override
    public void executeUseCase(RequestCommand<EditarCostoAuto> editarCostoAutoRequestCommand) {
        var command = editarCostoAutoRequestCommand.getCommand();
        var costo = new Costo(command.getCosto().value());
        emit().onResponse(new ResponseEvents(costo.getUncommittedChanges()));
    }
}
