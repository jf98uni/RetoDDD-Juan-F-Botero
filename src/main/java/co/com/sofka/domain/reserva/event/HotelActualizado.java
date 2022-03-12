package co.com.sofka.domain.reserva.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.reserva.valor.HotelID;

public class HotelActualizado extends DomainEvent {
    private final HotelID hotelID;
    public HotelActualizado(HotelID hotelID) {
        super("reserva.actualizarhotel");
        this.hotelID= hotelID;
    }

    public HotelID getHotelID() {
        return hotelID;
    }
}
