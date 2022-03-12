package co.com.sofka.domain.reserva;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.reserva.event.*;

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
            reserva.factura.editarCosto(event.getCosto());


        });

        apply((CostoEditadoAuto event) ->{

            reserva.transporte.editarCosto(event.getCosto());

        });

        apply((AutoCambiado event) ->{
            reserva.transporte.cambiarAuto(event.getAuto());

        });

        apply((EstadoCambiado event) ->{
            reserva.cambiarEstado(event.getEstado());

        });

        apply((TransporteCreado event) ->{
            reserva.crearTransporte(event.getTransporteID(),event.getCosto(), event.getAuto());

        });
        apply((ClienteActualizado event) ->{
            reserva.actualizarCliente(event.getClienteID());
        });

        apply((HotelActualizado event) ->{
            reserva.actualizarHotel(event.getHotelID());
        });




    }

}
