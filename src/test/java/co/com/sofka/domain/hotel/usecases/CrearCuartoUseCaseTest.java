package co.com.sofka.domain.hotel.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.hotel.command.CrearCuarto;
import co.com.sofka.domain.hotel.event.CuartoCreado;
import co.com.sofka.domain.hotel.valor.CuartoID;
import co.com.sofka.domain.hotel.valor.HotelID;
import co.com.sofka.domain.hotel.valor.Personal;
import co.com.sofka.domain.reserva.command.CrearFactura;
import co.com.sofka.domain.reserva.event.FacturaCreada;
import co.com.sofka.domain.reserva.usecases.CrearFacturaUseCase;
import co.com.sofka.domain.reserva.valor.Costo;
import co.com.sofka.domain.reserva.valor.FacturaID;
import co.com.sofka.domain.reserva.valor.ReservaID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearCuartoUseCaseTest {

    @Test
    public void crearCuarto(){
        HotelID hotelID = new HotelID();
        CuartoID cuartoID = new CuartoID();
        Personal personal = new Personal("Juan","botero","gerente");

        var command = new CrearCuarto(hotelID,cuartoID,personal);
        var usecase = new CrearCuartoUseCase();
        // act

        var events = UseCaseHandler.getInstance().setIdentifyExecutor(cuartoID.value())
                .syncExecutor(usecase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //assert
        var event =(CuartoCreado)events.get(0);
        Assertions.assertEquals("hotel.crearcuarto",event.type);
        Assertions.assertEquals(personal,event.getPersonal());
    }

}