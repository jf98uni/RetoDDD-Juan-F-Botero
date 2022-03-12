package co.com.sofka.domain.reserva;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.reserva.event.CostoEditado;
import co.com.sofka.domain.reserva.event.ReservaCreada;
import co.com.sofka.domain.reserva.event.FacturaCreada;
import co.com.sofka.domain.reserva.valor.*;


public class Reserva extends AggregateEvent<ReservaID> {

    protected Factura factura;
    protected ClienteID clienteID;
    protected HotelID hotelID;
    protected Transporte transporte;



    public Reserva(ReservaID reservaID, ClienteID clienteID, HotelID hotelID) {
        super(reservaID);
        appendChange(new ReservaCreada(clienteID,hotelID)).apply();
        subscribe(new ReservaEventChange(this));
    }

    public void crearFactura (FacturaID facturaID, Costo costo){
        appendChange(new FacturaCreada(facturaID,costo)).apply();
    }

    public void editarCosto(Costo costo){
        appendChange(new CostoEditado(costo)).apply();
    }


}
