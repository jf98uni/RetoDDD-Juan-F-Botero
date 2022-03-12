package co.com.sofka.domain.reserva.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.reserva.valor.ClienteID;

public class ClienteActualizado extends DomainEvent {
    private final ClienteID clienteID;
    public ClienteActualizado(ClienteID clienteID) {
        super("reserva.actualizarcliente");
        this.clienteID = clienteID;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }
}
