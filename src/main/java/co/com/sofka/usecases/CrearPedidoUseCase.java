package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.pedido.Pedido;
import co.com.sofka.domain.pedido.command.CrearPedido;

public class CrearPedidoUseCase extends UseCase<RequestCommand<CrearPedido>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearPedido> input) {
        CrearPedido crearPedido = input.getCommand();

        Pedido pedido = new Pedido(crearPedido.getPedidoId(), crearPedido.getClienteId());
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
