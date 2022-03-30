package co.com.sofka.domain.cliente.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.cliente.commands.CrearCliente;
import co.com.sofka.domain.cliente.commands.RealizarCompra;
import co.com.sofka.domain.cliente.event.ClienteCreado;
import co.com.sofka.domain.cliente.event.CompraRealizada;
import co.com.sofka.domain.cliente.valor.DatosCliente;
import co.com.sofka.domain.cliente.valor.Tarjeta;
import co.com.sofka.domain.reserva.valor.ClienteID;
import co.com.sofka.domain.reserva.valor.Estado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RealizarCompraUseCaseTest {
    @Test
    public void hacerCompra(){
        ClienteID clienteID = new ClienteID();
        Tarjeta tarjeta = new Tarjeta(1000.0,"1234123412341234");
        Estado estado = new Estado(Estado.Fase.Confirmado);

        var command = new RealizarCompra(clienteID,tarjeta,estado);
        var usecase = new RealizarCompraUseCase();
        // act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //assert
        var event =(CompraRealizada)events.get(0);
        Assertions.assertEquals("cliente.realizarcompra",event.type);
        Assertions.assertEquals(tarjeta,event.getTarjeta());
        Assertions.assertEquals(estado,event.getEstado());

    }

}