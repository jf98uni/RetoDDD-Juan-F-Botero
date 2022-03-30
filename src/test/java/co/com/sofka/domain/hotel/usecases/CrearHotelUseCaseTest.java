package co.com.sofka.domain.hotel.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.hotel.command.CrearHotel;
import co.com.sofka.domain.hotel.event.HotelCreado;
import co.com.sofka.domain.hotel.valor.DatosHotel;
import co.com.sofka.domain.hotel.valor.HotelID;
import co.com.sofka.domain.reserva.command.CrearFactura;
import co.com.sofka.domain.reserva.event.FacturaCreada;
import co.com.sofka.domain.reserva.usecases.CrearFacturaUseCase;
import co.com.sofka.domain.reserva.valor.Costo;
import co.com.sofka.domain.reserva.valor.FacturaID;
import co.com.sofka.domain.reserva.valor.ReservaID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearHotelUseCaseTest {

    @Test
    public void crearHotel(){
        HotelID hotelID = new HotelID();
        DatosHotel datosHotel = new DatosHotel("Hotel1","QuintanaRoo");

        var command = new CrearHotel(hotelID,datosHotel);
        var usecase = new CrearHotelUseCase();
        // act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //assert
        var event =(HotelCreado)events.get(0);
        Assertions.assertEquals("hotel.crearhotel",event.type);
        Assertions.assertEquals(datosHotel,event.getDatosHotel());
    }

}