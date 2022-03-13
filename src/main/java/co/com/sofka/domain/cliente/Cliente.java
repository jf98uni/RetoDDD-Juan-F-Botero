package co.com.sofka.domain.cliente;

import co.com.sofka.domain.cliente.event.*;
import co.com.sofka.domain.cliente.valor.DatosCliente;
import co.com.sofka.domain.cliente.valor.Tarjeta;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.reserva.valor.ClienteID;
import co.com.sofka.domain.reserva.valor.Estado;


public class Cliente extends AggregateEvent<ClienteID> {


    protected Compra compra;
    protected DatosCliente datosCliente;

    public Cliente(ClienteID clienteID,DatosCliente datosCliente) {
        super(clienteID);
        appendChange(new ClienteCreado(clienteID,datosCliente)).apply();
        subscribe(new ClienteEventChange(this));
    }

    public void editarDatos(String nombre, String apellido){
        applyEvent(new DatosEditados(nombre,apellido));
    }

    public void hacerCompra(Tarjeta tarjeta, Estado estado){
        applyEvent(new CompraRealizada(tarjeta,estado));
    }

    public void asignarInfoDePago(Double monto, String numero){
        applyEvent(new InfoDePagoAsignada(monto,numero));
    }

    public void editarEstado(Estado estado){
        applyEvent(new EstadoEditado(estado));
    }
}
