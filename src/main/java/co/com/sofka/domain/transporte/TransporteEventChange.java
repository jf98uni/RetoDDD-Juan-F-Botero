package co.com.sofka.domain.transporte;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.transporte.event.DestinatorioCambiado;
import co.com.sofka.domain.transporte.event.OrdenCreada;
import co.com.sofka.domain.transporte.event.OrdenEntregada;
import co.com.sofka.domain.transporte.event.TransporteCreado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class TransporteEventChange extends EventChange {
    public TransporteEventChange(Transporte transporte) {

        apply((TransporteCreado event) -> {
            transporte.conductorId = event.getConductorId();
            transporte.paquetes = new ArrayList<>();
            transporte.rutas = new ArrayList<>();
            transporte.ordenes = new HashMap<>();
        });

        apply((OrdenCreada event) -> {
            transporte.ordenes.put(
                    event.getOrdenId().value(),
                    new Orden(event.getOrdenId(), event.getRemitente(), event.getDestinatario())
            );
        });

        apply((OrdenEntregada event) -> {
            transporte.ordenes.get(event.getOrdenId().value()).entregarOrden();
        });

        apply((DestinatorioCambiado event) -> {
            if(Objects.isNull(transporte.ordenes.get(event.getOrdenId().value()))){
                throw new IllegalArgumentException("La orden no existe");
            }
            transporte.ordenes.get(event.getOrdenId().value()).cambiarDestinatario(event.getDestinatario());
        });
    }
}
