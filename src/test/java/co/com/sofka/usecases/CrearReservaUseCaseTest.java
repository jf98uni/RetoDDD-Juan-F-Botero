package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.reserva.command.CrearReserva;
import co.com.sofka.domain.reserva.event.ReservaCreada;
import co.com.sofka.domain.reserva.usecases.CrearReservaUseCase;
import co.com.sofka.domain.reserva.valor.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearReservaUseCaseTest {


    @Test
    void CrearReserva(){
        //arrange

        ReservaID reservaID = new ReservaID();
        ClienteID clienteID = ClienteID.of("ansdjn");
        HotelID hotelID = HotelID.of("fasdkngs");
        Estado estado = new Estado(Estado.Fase.Confirmado);
        var command = new CrearReserva(reservaID,clienteID,hotelID,estado);
        var usecase = new CrearReservaUseCase();
        // act

        var events =  UseCaseHandler.getInstance().syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert

        var event = (ReservaCreada)events.get(0);
        Assertions.assertEquals("reserva.reservacreada",event.type);
        Assertions.assertEquals("ansdjn",event.getClienteID().value());
        Assertions.assertEquals(reservaID.value(),event.aggregateRootId());
    }

}