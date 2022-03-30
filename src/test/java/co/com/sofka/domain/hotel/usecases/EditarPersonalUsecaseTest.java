package co.com.sofka.domain.hotel.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.hotel.command.CrearCuarto;
import co.com.sofka.domain.hotel.command.EditarPersonal;
import co.com.sofka.domain.hotel.event.CuartoCreado;
import co.com.sofka.domain.hotel.event.PersonalEditado;
import co.com.sofka.domain.hotel.valor.CuartoID;
import co.com.sofka.domain.hotel.valor.HotelID;
import co.com.sofka.domain.hotel.valor.Personal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditarPersonalUsecaseTest {

    @Test
    public void editarPersonal(){
        HotelID hotelID = new HotelID();
        CuartoID cuartoID = new CuartoID();
        Personal personal = new Personal("Asdsa",
                "ads","asdasd");

        var command = new EditarPersonal(hotelID,cuartoID,personal);
        var usecase = new EditarPersonalUsecase();
        // act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //assert
        var event =(PersonalEditado)events.get(0);
        Assertions.assertEquals("hotel.editarpersonal",event.type);
        Assertions.assertEquals(personal,event.getPersonal());
    }

}