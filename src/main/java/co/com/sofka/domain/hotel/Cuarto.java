package co.com.sofka.domain.hotel;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.hotel.valor.CuartoID;
import co.com.sofka.domain.hotel.valor.Personal;

public class Cuarto extends Entity<CuartoID> {

    private Personal personal;



    public Cuarto(CuartoID cuartoID,Personal personal) {
        super(cuartoID);
        this.personal = personal;
    }

    public void editarPersonal(Personal personal){
        this.personal = personal;
    }

    public Personal personal() {
        return personal;
    }
}
