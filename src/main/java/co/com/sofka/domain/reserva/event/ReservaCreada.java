package co.com.sofka.domain.reserva.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.reserva.valor.ClienteID;
import co.com.sofka.domain.reserva.valor.Estado;
import co.com.sofka.domain.reserva.valor.FacturaID;
import co.com.sofka.domain.reserva.valor.HotelID;


public class ReservaCreada extends DomainEvent {

    private final ClienteID clienteID;
    private final HotelID hotelID;

    private final Estado estado;

    public ReservaCreada(ClienteID clienteID, HotelID hotelID, Estado estado) {
        super("reserva.crearreserva");
        this.clienteID = clienteID;
        this.hotelID = hotelID;

        this.estado = new Estado(Estado.Fase.no_Confirmado);
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public HotelID getHotelID() {
        return hotelID;
    }



    public Estado getEstado() {
        return estado;
    }
}
