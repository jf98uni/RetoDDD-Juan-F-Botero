package co.com.sofka.domain.reserva.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;

import co.com.sofka.domain.reserva.ReservaEventChange;
import co.com.sofka.domain.reserva.command.CrearFactura;
import co.com.sofka.domain.reserva.event.FacturaCreada;
import co.com.sofka.domain.reserva.event.ReservaCreada;
import co.com.sofka.domain.reserva.usecases.CrearFacturaUseCase;
import co.com.sofka.domain.reserva.valor.Costo;
import co.com.sofka.domain.reserva.valor.FacturaID;
import co.com.sofka.domain.reserva.valor.ReservaID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class CrearFacturaUseCaseTest {

    @Test
    public void crearFactura() {

        var reservaId = new ReservaID();
        FacturaID facturaID = new FacturaID();
        Costo costo = new Costo(1000.0);

        var command = new CrearFactura( reservaId, new FacturaID(), costo);
        var usecase = new CrearFacturaUseCase();
        // act

        var events = UseCaseHandler.getInstance().setIdentifyExecutor(facturaID.value())
                .syncExecutor(usecase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //assert
        var event =(FacturaCreada)events.get(0);
        Assertions.assertEquals("reserva.crearfactura",event.type);
        Assertions.assertEquals(1000.0,event.getCosto().value());
        Assertions.assertEquals(reservaId.value(),event.aggregateRootId());

    }
}

