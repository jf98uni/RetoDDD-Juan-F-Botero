package co.com.sofka.domain.hotel.valor;

import co.com.sofka.domain.generic.ValueObject;

public class DatosHotel implements ValueObject<DatosHotel.Props> {

    private final String nombre;
    private final String locacion;

    public DatosHotel(String nombre, String locacion) {
        this.nombre = nombre;
        this.locacion = locacion;
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
