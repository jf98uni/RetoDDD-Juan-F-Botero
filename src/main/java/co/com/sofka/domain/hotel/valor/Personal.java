package co.com.sofka.domain.hotel.valor;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.ValueObject;
import java.util.Collections;

import java.util.List;
import java.util.Objects;

public class Personal implements ValueObject<Personal.Props> {
    private final String nombre;
    private final String apellido;
    private final String cargo;

    public Personal(String nombre, String apellido, String cargo) {

        this.nombre = Objects.requireNonNull(nombre);
        this.apellido = Objects.requireNonNull(apellido);
        this.cargo = Objects.requireNonNull(cargo);
    }

    @Override
    public Props value() {
        return new Props() {

            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public String apellido() {
                return apellido;
            }

            @Override
            public String cargo() {
                return cargo;
            }
        };
    }


    public interface Props{
        String nombre();
        String apellido();
        String cargo();
    }

    @Override
    public String toString() {
        return "{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", identidad='" + cargo + '\'' +
                '}';
    }


}
