package co.com.sofka.domain.cliente.commands;

import co.com.sofka.domain.cliente.valor.DatosCliente;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.reserva.valor.ClienteID;


public class CrearCliente extends Command {

    private final ClienteID clienteID;
    private final DatosCliente datosCliente;


    public CrearCliente(ClienteID clienteID, DatosCliente datosCliente) {
        this.clienteID = clienteID;
        this.datosCliente = datosCliente;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public DatosCliente getDatosCliente() {
        return datosCliente;
    }
}
