package co.com.sofka.domain.transporte.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Date;

public class Fecha implements ValueObject<LocalDate> {
    private final LocalDate value;

    public Fecha(LocalDate value) {
        this.value = value;//TODO: validar fechas, si se permite en el pasado, fechas en el futuro...
    }

    public Fecha() {
       this(LocalDate.now());
    }

    @Override
    public LocalDate value() {
        return value;
    }
}
