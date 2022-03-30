package co.com.sofka.domain.reserva;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.reserva.event.*;
import co.com.sofka.domain.reserva.valor.*;

import java.time.temporal.ValueRange;
import java.util.List;


public class Reserva extends AggregateEvent<ReservaID> {

    protected Factura factura;
    protected ClienteID clienteID;
    protected HotelID hotelID;
    protected Transporte transporte;
    protected Estado estado;


    public Reserva(ReservaID reservaID, ClienteID clienteID, HotelID hotelID, Estado estado) {
        super(reservaID);
        appendChange(new ReservaCreada(clienteID,hotelID, estado)).apply();
        subscribe(new ReservaEventChange(this));
    }

    public Reserva(ReservaID reservaID){
        super(reservaID);
        subscribe(new ReservaEventChange(this));
    }

    public static Reserva from(ReservaID reservaID, List<DomainEvent> events){
        var reserva = new Reserva(reservaID);
        events.forEach(reserva::applyEvent);
        return reserva;
    }


    public void crearFactura (FacturaID facturaID, Costo costo){
        appendChange(new FacturaCreada(facturaID,costo)).apply();
    }

    public void editarCostoAuto(Costo costo1){
        appendChange(new CostoEditadoAuto(costo1)).apply();
    }

    public void editarCostoFactura(FacturaID facturaID ,Costo costo){
        appendChange(new CostoEditadoFactura(facturaID ,costo)).apply();
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
