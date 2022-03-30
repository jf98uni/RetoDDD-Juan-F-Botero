package co.com.sofka.domain.hotel.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.hotel.Hotel;
import co.com.sofka.domain.hotel.valor.CuartoID;
import co.com.sofka.domain.hotel.valor.HotelID;
import co.com.sofka.domain.hotel.valor.Personal;

public class PersonalEditado extends DomainEvent {
    private final HotelID hotelID;
    private final CuartoID cuartoID;
    private final Personal personal;


    public PersonalEditado(HotelID hotelID, CuartoID cuartoID, Personal personal) {
        super("hotel.editarpersonal");
        this.cuartoID = cuartoID;
        this.personal =  personal;
        this.hotelID =hotelID;

    }

    public CuartoID getCuartoID() {
        return cuartoID;
    }

    public Personal getPersonal() {
        return personal;
    }

    public HotelID getHotelID() {
        return hotelID;
    }
}
