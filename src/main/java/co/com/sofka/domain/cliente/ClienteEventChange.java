package co.com.sofka.domain.cliente;

import co.com.sofka.domain.cliente.event.ClienteCreado;
import co.com.sofka.domain.cliente.event.CompraRealizada;
import co.com.sofka.domain.generic.EventChange;

public class ClienteEventChange extends EventChange {
    public ClienteEventChange(Cliente cliente) {

        apply((ClienteCreado event) ->{
            cliente.datosCliente= event.getDatosCliente();
        } );
        apply((CompraRealizada event) ->{
            cliente.hacerCompra(event.getTarjeta(),event.getEstado());
        });

    }
}
