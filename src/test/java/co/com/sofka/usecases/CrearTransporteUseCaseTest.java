package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.transporte.command.CrearTransporte;
import co.com.sofka.domain.transporte.event.TransporteCreado;
import co.com.sofka.domain.transporte.valor.ConductorId;
import co.com.sofka.domain.transporte.valor.TransporteId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearTransporteUseCaseTest {


    @Test
    void crearTranposte(){
        //arrange
        TransporteId transporteId = new TransporteId();
        ConductorId conductorId =  ConductorId.of("xxxxx");
        var command = new CrearTransporte(transporteId, conductorId);
        var usecase = new CrearTransporteUseCase();
        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (TransporteCreado)events.get(0);
        Assertions.assertEquals("transporte.transportecreado", event.type);
        Assertions.assertEquals("xxxxx",event.getConductorId().value());
        Assertions.assertEquals(transporteId.value(),event.aggregateRootId());
    }
}