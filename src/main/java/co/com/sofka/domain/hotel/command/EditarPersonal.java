package co.com.sofka.domain.hotel.command;

import co.com.sofka.domain.generic.Command;

public class EditarPersonal extends Command {

    private final String nombre;
    private final String apellido;
    private final String cargo;

    public EditarPersonal(String nombre, String apellido, String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCargo() {
        return cargo;
    }
}
