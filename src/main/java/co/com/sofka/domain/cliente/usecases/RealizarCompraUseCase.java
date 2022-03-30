package co.com.sofka.domain.cliente.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.cliente.Cliente;
import co.com.sofka.domain.cliente.commands.RealizarCompra;

public class RealizarCompraUseCase extends UseCase<RequestCommand<RealizarCompra>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<RealizarCompra> realizarCompraRequestCommand) {
        var command = realizarCompraRequestCommand.getCommand();

        var cliente =  new Cliente(command.getClienteID());

        cliente.hacerCompra(command.getTarjeta(),command.getEstado());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
