package co.com.sofka.domain.reserva.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.reserva.command.CrearFactura;
import co.com.sofka.domain.reserva.command.CrearTransporte;
import co.com.sofka.domain.reserva.event.FacturaCreada;
import co.com.sofka.domain.reserva.event.TransporteCreado;
import co.com.sofka.domain.reserva.valor.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


class CrearTransporteUseCaseTest {

    @Test
    void crearTransporte() throws Exception {


        var reservaId = new ReservaID();
        TransporteID transporteID = new TransporteID();
        Costo costo = new Costo(1000.0);
        Auto auto = new Auto("rkn206");
        var command = new CrearTransporte( reservaId,transporteID,costo,auto);
        var usecase = new CrearTransporteUseCase();
        // act


        var events = UseCaseHandler.getInstance().syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow().getDomainEvents();

        //assert
        var event =(TransporteCreado)events.get(0);
        Assertions.assertEquals("reserva.creartransporte",event.type);
        Assertions.assertEquals("rkn206",event.getAuto().value());
        Assertions.assertEquals(1000.0,event.getCosto().value());
        Assertions.assertEquals(transporteID.value(),event.getTransporteID().value());
        Assertions.assertEquals(reservaId.value(),event.aggregateRootId());

    }
}