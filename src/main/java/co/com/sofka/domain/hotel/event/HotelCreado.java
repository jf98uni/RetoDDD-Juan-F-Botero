package co.com.sofka.domain.hotel.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.hotel.valor.CuartoID;
import co.com.sofka.domain.hotel.valor.DatosHotel;
import co.com.sofka.domain.hotel.valor.Personal;

public class HotelCreado extends DomainEvent {

    private final DatosHotel datosHotel;

    public HotelCreado(DatosHotel datosHotel) {
        super("hotel.crearhotel");
        this.datosHotel = datosHotel;
    }

    public DatosHotel getDatosHotel() {
        return datosHotel;
    }
}
