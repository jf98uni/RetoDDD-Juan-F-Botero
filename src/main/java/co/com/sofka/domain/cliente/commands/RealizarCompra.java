package co.com.sofka.domain.cliente.commands;

import co.com.sofka.domain.cliente.valor.Tarjeta;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.reserva.valor.ClienteID;
import co.com.sofka.domain.reserva.valor.Estado;

public class RealizarCompra extends Command {
    private final ClienteID clienteID;
    private final Tarjeta tarjeta;
    private final Estado estado;

    public RealizarCompra(ClienteID clienteID ,Tarjeta tarjeta, Estado estado) {
        this.clienteID = clienteID;
        this.tarjeta = tarjeta;
        this.estado = estado;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public Estado getEstado() {
        return estado;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }
}
