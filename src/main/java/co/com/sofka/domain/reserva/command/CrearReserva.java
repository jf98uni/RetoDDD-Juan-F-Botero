package co.com.sofka.domain.reserva.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.reserva.valor.*;

public class CrearReserva extends Command {


    private final ReservaID reservaID;
    private final ClienteID clienteID;
    private final HotelID hotelID;
    private final Estado estado;

    public CrearReserva(ReservaID reservaID, ClienteID clienteID, HotelID hotelID, Estado estado) {
        this.reservaID = reservaID;
        this.clienteID = clienteID;
        this.hotelID = hotelID;
        this.estado = estado;
    }

    public ReservaID getReservaID() {
        return reservaID;
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
