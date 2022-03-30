package co.com.sofka.domain.hotel.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.hotel.Hotel;
import co.com.sofka.domain.hotel.valor.CuartoID;
import co.com.sofka.domain.hotel.valor.HotelID;
import co.com.sofka.domain.hotel.valor.Personal;

public class EditarPersonal extends Command {

    private final HotelID hotelID;
    private final CuartoID cuartoID;
    private final Personal personal;


    public EditarPersonal(HotelID hotelID, CuartoID cuartoID,Personal personal) {

        this.hotelID = hotelID;
        this.cuartoID = cuartoID;
        this.personal = personal;
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
