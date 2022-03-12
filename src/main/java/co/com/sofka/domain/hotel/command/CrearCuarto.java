package co.com.sofka.domain.hotel.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.hotel.valor.CuartoID;
import co.com.sofka.domain.hotel.valor.Personal;

public class CrearCuarto extends Command {
    private final CuartoID cuartoID;
    private final Personal personal;


    public CrearCuarto(CuartoID cuartoID, Personal personal) {
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
