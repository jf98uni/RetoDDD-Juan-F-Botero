package co.com.sofka.domain.reserva.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.reserva.valor.ClienteID;
import co.com.sofka.domain.reserva.valor.HotelID;

import java.lang.reflect.Type;


public class ReservaCreada extends DomainEvent {

    private final ClienteID clienteID;
    private final HotelID hotelID;

    public ReservaCreada(ClienteID clienteID, HotelID hotelID) {
        super("reserva.reservacreada");
        this.clienteID = clienteID;
        this.hotelID = hotelID;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public HotelID getHotelID() {
        return hotelID;
    }
}
