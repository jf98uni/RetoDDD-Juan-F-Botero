package co.com.sofka.domain.reserva.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.reserva.valor.Auto;
import co.com.sofka.domain.reserva.valor.Costo;
import co.com.sofka.domain.reserva.valor.HotelID;
import co.com.sofka.domain.reserva.valor.ReservaID;

public class ActualizarHotel extends Command {

    private  final HotelID hotelID;

    public ActualizarHotel(HotelID hotelID) {

        this.hotelID = hotelID;
    }

    public HotelID getCosto() {
        return hotelID;
    }


}
