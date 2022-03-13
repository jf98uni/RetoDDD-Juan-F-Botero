package co.com.sofka.domain.hotel.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.hotel.command.EditarPersonal;
import co.com.sofka.domain.hotel.valor.Personal;

public class EditarPersonalUsecase extends UseCase <RequestCommand<EditarPersonal>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<EditarPersonal> editarPersonalRequestCommand) {
        var command = editarPersonalRequestCommand.getCommand();
        var personal = new Personal(command.getNombre(),command.getApellido(),command.getCargo());
        emit().onResponse(new ResponseEvents(personal.getUncommittedChanges()));
    }

}
