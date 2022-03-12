package co.com.sofka.usecases;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CambiarDestinatarioUseCase extends UseCase<RequestCommand<CambiarDestinatario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarDestinatario> input) {
        var command = input.getCommand();
        var transporte = Reserva.from(command.getTransporteId(), retrieveEvents());
        try {
            transporte.cambiarDestinatorioParaLaOrden(command.getOrdenId(), command.getDestinatario());
        } catch (IllegalArgumentException e){
            throw new BusinessException(command.getTransporteId().value(), e.getMessage(), e);
        }

        emit().onResponse(new ResponseEvents(transporte.getUncommittedChanges()));
    }
}
