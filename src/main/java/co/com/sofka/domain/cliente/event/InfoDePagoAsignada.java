package co.com.sofka.domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;

public class InfoDePagoAsignada extends DomainEvent {

    private final Double monto;
    private final String numero;


    public InfoDePagoAsignada(Double monto, String numero) {
        super("cliente.asignarinfodepago");
        this.monto = monto;
        this.numero = numero;
    }

    public Double getMonto() {
        return monto;
    }

    public String getNumero() {
        return numero;
    }
}
