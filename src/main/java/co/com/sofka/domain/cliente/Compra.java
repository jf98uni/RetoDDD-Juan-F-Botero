package co.com.sofka.domain.cliente;

import co.com.sofka.domain.cliente.valor.CompraID;
import co.com.sofka.domain.cliente.valor.Estado;
import co.com.sofka.domain.cliente.valor.Tarjeta;
import co.com.sofka.domain.generic.Entity;


public class Compra extends Entity<CompraID> {

    private Tarjeta tarjeta;
    private Estado estado;

    public Compra(CompraID entityId,Tarjeta tarjeta,Estado estado) {
        super(entityId);
        this.tarjeta = tarjeta;
        this.estado = estado;
    }

    public void asignarInfoDePago(Tarjeta tarjeta){

        this.tarjeta = tarjeta;

    }

    public void cambiarEstado(Estado estado){
        this.estado = estado;
    }

    public Tarjeta tarjeta() {
        return tarjeta;
    }

    public Estado estado() {
        return estado;
    }
}
