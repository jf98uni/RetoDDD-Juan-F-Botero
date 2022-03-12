package co.com.sofka.domain.reserva.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.reserva.valor.ClienteID;
import co.com.sofka.domain.reserva.valor.HotelID;
import co.com.sofka.domain.reserva.valor.ReservaID;

public class CrearReserva extends Command {


    private final ReservaID reservaID;
    private final ClienteID clienteID;
    private final HotelID hotelID;

    public CrearReserva(ReservaID reservaID, ClienteID clienteID, HotelID hotelID) {
        this.reservaID = reservaID;
        this.clienteID = clienteID;
        this.hotelID = hotelID;
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
}
