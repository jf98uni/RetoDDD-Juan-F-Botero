package co.com.sofka.domain.cliente.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;


public class DatosCliente implements ValueObject<DatosCliente.Props> {

    private final String nombre;
    private final String apellido;

    public DatosCliente(String nombre, String apellido) {
        this.nombre = Objects.requireNonNull(nombre) ;
        this.apellido = Objects.requireNonNull(apellido);
    }


    @Override
    public DatosCliente.Props value() {
        return new DatosCliente.Props() {

            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public String apellido() {
                return apellido;
            }


        };
    }

    public interface Props{
        String nombre();
        String apellido();

    }

    @Override
    public String toString() {
        return "{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido +
                '}';
    }
}
