package co.com.sofka.domain.reserva.valor;

import co.com.sofka.domain.generic.ValueObject;

public class Auto implements ValueObject<String> {

    private final String auto;

    public Auto(String auto) throws Exception {
        if( auto.length() == 6  ){this.auto = auto;}
        else throw new IllegalArgumentException("Ponga una placa valida");
    }


    @Override
    public String value() {
        return auto;
    }


}
