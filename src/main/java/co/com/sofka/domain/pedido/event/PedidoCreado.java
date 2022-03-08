package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.ClienteId;
import co.com.sofka.domain.generic.DomainEvent;

public class PedidoCreado extends DomainEvent {
    private final ClienteId clienteId;

    public PedidoCreado(ClienteId clienteId) {
        super("pedido.pedidocreado");
        this.clienteId = clienteId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}
