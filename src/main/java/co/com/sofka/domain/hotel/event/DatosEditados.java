package co.com.sofka.domain.hotel.event;

import co.com.sofka.domain.generic.DomainEvent;

public class DatosEditados extends DomainEvent {
    private final String nombre;
    private final String location;

    public DatosEditados(String nombre, String locacion) {
        super("hotel.editarDatos");
        this.nombre = nombre;
        this.location = locacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLocation() {
        return location;
    }
}
