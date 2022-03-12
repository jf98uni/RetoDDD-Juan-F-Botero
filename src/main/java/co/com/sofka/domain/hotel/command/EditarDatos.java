package co.com.sofka.domain.hotel.command;

import co.com.sofka.domain.generic.Command;

public class EditarDatos extends Command {
    private final String nombre;
    private final String locacion;

    public EditarDatos(String nombre, String locacion) {
        this.nombre = nombre;
        this.locacion = locacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLocacion() {
        return locacion;
    }
}
