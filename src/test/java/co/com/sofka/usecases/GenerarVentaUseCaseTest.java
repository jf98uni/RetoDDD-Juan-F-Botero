package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.ClienteId;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Precio;
import co.com.sofka.domain.generic.ProductoId;
import co.com.sofka.domain.pedido.command.GenerarVenta;
import co.com.sofka.domain.pedido.event.PedidoCreado;
import co.com.sofka.domain.pedido.event.VentaGenerada;
import co.com.sofka.domain.pedido.value.CantidadPedida;
import co.com.sofka.domain.pedido.value.MetodoDePago;
import co.com.sofka.domain.pedido.value.PedidoId;
import co.com.sofka.domain.pedido.value.PrecioNeto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class GenerarVentaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void generarVenta() {
        //arrange
        PedidoId pedidoId = PedidoId.of("xxxxx");
        MetodoDePago metodoDePago = new MetodoDePago("EFECTIVO");
        Precio precio = new Precio(3000D);
        PrecioNeto precioNeto = new PrecioNeto(3300D);
        ProductoId productoId = ProductoId.of("xxxxx");
        CantidadPedida cantidadPedida = new CantidadPedida(10);

        var command = new GenerarVenta(pedidoId, metodoDePago, precio, precioNeto, productoId, cantidadPedida);
        Mockito.when(repository.getEventsBy("xxxxx")).thenReturn(events());//la simulacion del comportamiento

        var usecase = new GenerarVentaUseCase();
        usecase.addRepository(repository);
        //act


        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (VentaGenerada)events.get(0);
        Assertions.assertEquals("pedido.ventagenerada", event.type);
        Assertions.assertEquals("EFECTIVO", event.getMetodoDePago().value());
        Assertions.assertEquals("EFECTIVO", event.ge().value());
        Assertions.assertEquals("xxxxx", event.aggregateRootId());
    }

    private List<DomainEvent> events() {
        return List.of(new PedidoCreado(ClienteId.of("xxxx")));
    }

}