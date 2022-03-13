package co.com.sofka.domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;

public class DatosEditados extends DomainEvent {
    private final String nombre;
    private final String apellido;

    public DatosEditados(String nombre, String apellido) {
        super("cliente.editarDatos");
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
