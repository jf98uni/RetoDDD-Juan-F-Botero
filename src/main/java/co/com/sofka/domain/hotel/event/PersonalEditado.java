package co.com.sofka.domain.hotel.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.hotel.valor.Personal;

import java.lang.management.ThreadInfo;

public class PersonalEditado extends DomainEvent {

    private final String nombre;
    private final String apellido;
    private final String cargo;

    public PersonalEditado(String nombre, String apellido, String cargo) {
        super("hotel.editarpersonal");
        this.apellido = apellido;
        this.cargo = cargo;
        this.nombre = nombre;
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
