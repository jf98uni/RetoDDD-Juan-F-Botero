package co.com.sofka.domain.reserva;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.reserva.event.*;
import co.com.sofka.domain.reserva.valor.*;


public class Reserva extends AggregateEvent<ReservaID> {

    protected Factura factura;
    protected ClienteID clienteID;
    protected HotelID hotelID;
    protected Transporte transporte;
    protected Estado estado;


    public Reserva(ReservaID reservaID, ClienteID clienteID, HotelID hotelID,Estado estado) {
        super(reservaID);
        appendChange(new ReservaCreada(clienteID,hotelID,estado)).apply();
        subscribe(new ReservaEventChange(this));
    }


    public void crearFactura (FacturaID facturaID, Costo costo){
        appendChange(new FacturaCreada(facturaID,costo)).apply();
    }

    public void editarCostoAuto(Costo costo){
        appendChange(new CostoEditadoAuto(costo)).apply();
    }

    public void editarCostoFactura(Costo costo){
        appendChange(new CostoEditadoFactura(costo)).apply();
    }

    public void cambiarAuto(Auto auto){
        appendChange(new AutoCambiado(auto)).apply();
    }

    public void  cambiarEstado(Estado estado){
        appendChange(new EstadoCambiado(estado)).apply();
    }

    public void crearTransporte(TransporteID entityId, Costo costo, Auto auto){
        appendChange(new TransporteCreado(entityId,costo,auto)).apply();
    }

    public void actualizarCliente (ClienteID clienteID){
        appendChange(new ClienteActualizado(clienteID)).apply();
    }

    public void actualizarHotel (HotelID hotelID){
        appendChange(new HotelActualizado(hotelID)).apply();
    }







}
