package co.com.sofka.domain.hotel.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.hotel.valor.CuartoID;
import co.com.sofka.domain.hotel.valor.Personal;

public class CuartoCreado extends DomainEvent {

    private final CuartoID cuartoID;
    private final Personal personal;

    public CuartoCreado(CuartoID cuartoID, Personal personal) {
        super("hotel.crearcuarto");
        this.cuartoID = cuartoID;
        this.personal = personal;
    }

    public CuartoID getCuartoID() {
        return cuartoID;
    }

    public Personal getPersonal() {
        return personal;
    }
}
