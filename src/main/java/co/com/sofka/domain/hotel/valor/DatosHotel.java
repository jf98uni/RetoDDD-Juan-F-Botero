package co.com.sofka.domain.hotel.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DatosHotel implements ValueObject<DatosHotel.Props> {

    private final String nombre;
    private final String locacion;

    public DatosHotel(String nombre, String locacion) {
        this.nombre = Objects.requireNonNull(nombre);
        this.locacion = Objects.requireNonNull(locacion);
    }


    @Override
    public Props value() {
        return new Props() {

            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public String locacion() {
                return locacion;
            }


        };
    }

    public interface Props{
        String nombre();
        String locacion();

    }

    @Override
    public String toString() {
        return "{" +
                "nombre='" + nombre + '\'' +
                ", locacion='" + locacion +
                '}';
    }

}
