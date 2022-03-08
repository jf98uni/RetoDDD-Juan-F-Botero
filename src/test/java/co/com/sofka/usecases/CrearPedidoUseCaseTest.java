package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.ClienteId;
import co.com.sofka.domain.pedido.event.PedidoCreado;
import co.com.sofka.domain.pedido.command.CrearPedido;
import co.com.sofka.domain.pedido.value.PedidoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearPedidoUseCaseTest {


    @Test
    void crearPedido(){
       //arrange
        PedidoId pedidoId = PedidoId.of("xxxxx");
        ClienteId clienteId = ClienteId.of("yyyyy");
        CrearPedido crearPedido = new CrearPedido(pedidoId, clienteId);
       //act
        CrearPedidoUseCase usecase = new CrearPedidoUseCase();
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(crearPedido))
                .orElseThrow()
                .getDomainEvents();
       //assert
        var event = (PedidoCreado)events.get(0);
        Assertions.assertEquals("pedido.pedidocreado", event.type);
        Assertions.assertEquals("yyyyy", event.getClienteId().value());
        Assertions.assertEquals("xxxxx", event.aggregateRootId());
    }
}