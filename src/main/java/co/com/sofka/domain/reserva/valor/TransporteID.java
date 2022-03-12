package co.com.sofka.domain.reserva.valor;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.generic.ValueObject;
import co.com.sofka.domain.reserva.Transporte;

public class TransporteID extends Identity {
    private TransporteID (String valor){
        super(valor);
    }
    public TransporteID(){}

    public static TransporteID of(String valor) {
        return new TransporteID(valor);

    }
}
