package co.com.sofka.domain.cliente.commands;

import co.com.sofka.domain.generic.Command;

public class AsignarInfoDePago extends Command {
    private final Double monto;
    private final String numero;


    public AsignarInfoDePago(Double monto, String numero) {

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
