package co.com.sofka.domain.cliente.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.cliente.commands.CrearCliente;
import co.com.sofka.domain.cliente.event.ClienteCreado;
import co.com.sofka.domain.cliente.valor.DatosCliente;
import co.com.sofka.domain.reserva.valor.ClienteID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CrearClienteUseCaseTest {

    @Test

    public void crearCliente(){
        ClienteID clienteID = new ClienteID();
        DatosCliente datosCliente = new DatosCliente("pepe","perales");

        var command = new CrearCliente(clienteID,datosCliente);
        var usecase = new CrearClienteUseCase();
        // act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //assert
        var event =(ClienteCreado)events.get(0);
        Assertions.assertEquals("cliente.crearcliente",event.type);
        Assertions.assertEquals(datosCliente,event.getDatosCliente());
    }

}