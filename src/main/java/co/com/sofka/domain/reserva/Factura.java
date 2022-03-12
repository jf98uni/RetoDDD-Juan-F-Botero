package co.com.sofka.domain.reserva;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.reserva.valor.Costo;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.reserva.valor.FacturaID;
import java.util.Collections;

import java.util.List;

public class Factura extends Entity<FacturaID> {
    private Costo costo;

    public Factura(FacturaID facturaID,Costo costo) {
        super(facturaID);
        this.costo = costo;
    }

    public void editarCosto(Costo costo){
        this.costo = costo;
    }

    public List<DomainEvent> getUncommittedChanges() {
        return Collections.emptyList();
    }
}
