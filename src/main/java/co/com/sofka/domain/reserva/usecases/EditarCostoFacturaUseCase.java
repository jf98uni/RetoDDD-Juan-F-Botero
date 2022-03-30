package co.com.sofka.domain.reserva.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.reserva.Reserva;
import co.com.sofka.domain.reserva.command.EditarCostoAuto;
import co.com.sofka.domain.reserva.command.EditarCostoFactura;
import co.com.sofka.domain.reserva.valor.Costo;
import co.com.sofka.domain.reserva.valor.ReservaID;

public class EditarCostoFacturaUseCase extends UseCase<RequestCommand<EditarCostoFactura>, ResponseEvents>  {


    @Override
    public void executeUseCase(RequestCommand<EditarCostoFactura> editarCostoFacturaRequestCommand) {
        var command = editarCostoFacturaRequestCommand.getCommand();

        var reserva = new Reserva(new ReservaID());

        reserva.editarCostoFactura(command.getFacturaID(),command.getCosto());

        emit().onResponse(new ResponseEvents(reserva.getUncommittedChanges()));
    }

}
