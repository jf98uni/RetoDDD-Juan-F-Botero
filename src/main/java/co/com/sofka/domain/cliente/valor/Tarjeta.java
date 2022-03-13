package co.com.sofka.domain.cliente.valor;

import co.com.sofka.domain.generic.ValueObject;

public class Tarjeta implements ValueObject<Tarjeta.Props> {

    private final Double monto;
    private final String numero;


    public Tarjeta(Double monto, String numero) {
        if (numero.length() == 16) {
            this.monto = monto;
            this.numero = numero;
        }
        else throw new IllegalArgumentException("numero de tarjeta invalido");
    }


    @Override
    public Tarjeta.Props value() {
        return new Tarjeta.Props() {

            @Override
            public Double monto() {
                return monto;
            }

            @Override
            public String numero() {
                return numero;
            }




        };
    }

    public interface Props{
        Double monto();
        String numero();


    }

    @Override
    public String toString() {
        return "{" +
                "monto='" + monto + '\'' +
                ", numero='" + numero +
                '}';
    }
}
