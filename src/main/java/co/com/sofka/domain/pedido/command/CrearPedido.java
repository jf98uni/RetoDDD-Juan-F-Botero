package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.ClienteId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.value.PedidoId;

public class CrearPedido extends Command {

    private final PedidoId pedidoId;
    private final ClienteId clienteId;

    public CrearPedido(PedidoId pedidoId, ClienteId clienteId) {
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }
}
