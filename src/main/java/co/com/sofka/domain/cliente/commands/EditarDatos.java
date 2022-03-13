package co.com.sofka.domain.cliente.commands;

import co.com.sofka.domain.generic.Command;

public class EditarDatos extends Command {
    private final String nombre;
    private final String apellido;

    public EditarDatos(String nombre, String apellido) {
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
