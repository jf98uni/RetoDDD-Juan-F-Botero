package co.com.sofka.usecases;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

import java.util.List;

public class NotificarCambioDeDestinatorioUseCase extends UseCase<TriggeredEvent<DestinatorioCambiado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<DestinatorioCambiado> input) {
        var event = input.getDomainEvent();
        var service = getService(SMSService.class).orElseThrow();

        var events = repository().getEventsBy("transporte", event.aggregateRootId());
        var transporte = Reserva.from(TransporteId.of(event.aggregateRootId()), events);
        var esOK = service.enviarMensajeAConductor(
                transporte.conductorId(),
                String.format("Se cambio la dirección de la orden %s, con el siguiente destino %s", event.getOrdenId(), event.getDestinatario())
        );
        if(esOK){
            emit().onResponse(new ResponseEvents(List.of()));
        } else {
            throw new BusinessException(event.aggregateRootId(), "No se puedo enviar el mensaje de texto");
        }

    }
}
