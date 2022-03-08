package co.com.sofka.domain.generic;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;

public class Fecha implements ValueObject<Date> {
    private final Date value;

    public Fecha() {
        this(new Date());
    }

    public Fecha(Date date) {
        //TODO: validaciones
        this.value = date;
    }

    @Override
    public Date value() {
        return value;
    }
}
