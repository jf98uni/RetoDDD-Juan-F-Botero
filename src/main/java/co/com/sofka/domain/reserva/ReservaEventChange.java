package co.com.sofka.domain.reserva;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.reserva.event.*;
import co.com.sofka.domain.reserva.valor.Costo;
import co.com.sofka.domain.reserva.valor.FacturaID;

public class ReservaEventChange extends EventChange {
    public ReservaEventChange(Reserva reserva) {

        apply((ReservaCreada event) ->{
            reserva.clienteID = event.getClienteID();
            reserva.hotelID = event.getHotelID();

            reserva.estado = event.getEstado();

        }
        );

        apply((FacturaCreada event) ->{
            reserva.factura = new Factura(event.getFacturaID(),event.getCosto());



        });
        apply((CostoEditadoFactura event) ->{
            reserva.factura.editarCostoFactura(event.getFacturaID(),event.getCosto());


        });

        apply((CostoEditadoAuto event) ->{

            reserva.editarCostoAuto(event.getCosto());

        });

        apply((AutoCambiado event) ->{
            reserva.transporte.cambiarAuto(event.getAuto());

        });

        apply((EstadoCambiado event) ->{
            reserva.cambiarEstado(event.getEstado());

        });

        apply((TransporteCreado event) ->{
            reserva.transporte =  new Transporte(event.getTransporteID(),event.getCosto(), event.getAuto());

        });
        apply((ClienteActualizado event) ->{
            reserva.actualizarCliente(event.getClienteID());
        });

        apply((HotelActualizado event) ->{
            reserva.actualizarHotel(event.getHotelID());
        });




    }

}
