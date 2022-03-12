package co.com.sofka.domain.reserva;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.reserva.event.CostoEditado;
import co.com.sofka.domain.reserva.event.FacturaCreada;
import co.com.sofka.domain.reserva.event.ReservaCreada;

public class ReservaEventChange extends EventChange {
    public ReservaEventChange(Reserva reserva) {

        apply((ReservaCreada event) ->{
            reserva.clienteID = event.getClienteID();
            reserva.hotelID = event.getHotelID();
        }
        );

        apply((FacturaCreada event) ->{
            reserva.factura = new Factura(event.getFacturaID(),event.getCosto());



        });

        apply((CostoEditado event) ->{
            reserva.factura.editarCosto(event.getCosto());


        });
    }

}
