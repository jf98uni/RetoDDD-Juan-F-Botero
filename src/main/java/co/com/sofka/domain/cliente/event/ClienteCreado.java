package co.com.sofka.domain.cliente.event;

import co.com.sofka.domain.cliente.ClienteEventChange;
import co.com.sofka.domain.cliente.valor.DatosCliente;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.reserva.valor.ClienteID;

import java.util.concurrent.DelayQueue;

public class ClienteCreado extends DomainEvent {

    private final ClienteID clienteID;
    private final DatosCliente datosCliente;

    public ClienteCreado(ClienteID clienteID, DatosCliente datosCliente) {
        super("cliente.crearcliente");
        this.clienteID = clienteID;
        this.datosCliente= datosCliente;

    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public DatosCliente getDatosCliente() {
        return datosCliente;
    }
}
