package co.com.sofka.domain.reserva.valor;

import co.com.sofka.domain.generic.Identity;

public class HotelID extends Identity {
    private HotelID (String valor){
        super(valor);
    }
    public HotelID(){}

    public static HotelID of(String valor) {
        return new HotelID(valor);

    }
}
