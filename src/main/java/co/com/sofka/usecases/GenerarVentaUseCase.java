package co.com.sofka.usecases;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.pedido.Pedido;
import co.com.sofka.domain.pedido.command.GenerarVenta;

import java.util.Objects;

public class GenerarVentaUseCase extends UseCase<RequestCommand<GenerarVenta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<GenerarVenta> input) {
        var command = input.getCommand();

        var pedido = Pedido.from(command.getPedidoId(), retrieveEvents());
        if(Objects.nonNull(pedido.venta())){//regla de negocio
            throw new BusinessException(command.getPedidoId().value(), "No se puede volver a generar la venta");
        }
        pedido.generarVenta(
                command.getProductoId(), command.getCantidadPedida(), command.getMetodoDePago(),command.getPrecio(), command.getPrecioNeto()
        );

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
