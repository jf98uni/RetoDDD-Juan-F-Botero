package co.com.sofka.domain.reserva.valor;

import co.com.sofka.domain.generic.Identity;

public class FacturaID extends Identity {
    private FacturaID(String valor){
        super(valor);
    }

    public FacturaID(){}
    public static FacturaID of(String valor) {
        return new FacturaID(valor);
    }
}
