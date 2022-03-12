package co.com.sofka.domain.hotel.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.hotel.valor.DatosHotel;
import co.com.sofka.domain.hotel.valor.HotelID;

public class CrearHotel extends Command {
    private final HotelID hotelID;
    private final DatosHotel datosHotel;

    public CrearHotel(HotelID hotelID, DatosHotel datosHotel) {
        this.hotelID = hotelID;
        this.datosHotel = datosHotel;
    }

    public HotelID getHotelID() {
        return hotelID;
    }

    public DatosHotel getDatosHotel() {
        return datosHotel;
    }
}
