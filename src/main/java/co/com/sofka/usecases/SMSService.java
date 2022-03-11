package co.com.sofka.usecases;

import co.com.sofka.domain.transporte.valor.ConductorId;

public interface SMSService {
    boolean enviarMensajeAConductor(ConductorId conductorId, String mensaje);
}
