package co.com.sofka.domain.reserva;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.reserva.valor.Auto;
import co.com.sofka.domain.reserva.valor.Costo;
import co.com.sofka.domain.reserva.valor.TransporteID;

public class Transporte extends Entity<TransporteID> {
    private Costo costo;
    private Auto auto;
    public Transporte(TransporteID entityId, Costo costo, Auto auto) {
        super(entityId);
        this.costo = costo;
        this.auto = auto;
    }

    public void cambiarAuto(Auto auto){

        this.auto = auto;

    }

    public void cambiarCosto(Costo costo){

        this.costo = costo;

    }



    public Costo costo() {
        return costo;
    }

    public Auto auto() {
        return auto;
    }
}
