package co.com.sofka.domain.cliente.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.reserva.valor.Estado;

public class EditarEstado extends Command {
    private final Estado estado;

    public EditarEstado(Estado estado) {

        this.estado=estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
