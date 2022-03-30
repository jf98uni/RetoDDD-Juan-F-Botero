package co.com.sofka.domain.hotel.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.hotel.Hotel;
import co.com.sofka.domain.hotel.event.CuartoCreado;
import co.com.sofka.domain.hotel.valor.CuartoID;
import co.com.sofka.domain.hotel.valor.HotelID;
import co.com.sofka.domain.hotel.valor.Personal;

public class CrearCuarto extends Command {
    private final HotelID hotelID;
    private final CuartoID cuartoID;
    private final Personal personal;


    public CrearCuarto(HotelID hotelID, CuartoID cuartoID, Personal personal) {
        this.cuartoID = cuartoID;
        this.personal = personal;
        this.hotelID = hotelID;
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
