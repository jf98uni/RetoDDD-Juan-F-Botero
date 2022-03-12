package co.com.sofka.usecases;

public interface SMSService {
    boolean enviarMensajeAConductor(ConductorId conductorId, String mensaje);
}
