package co.com.sofka.usecases;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class NotificarCambioDeDestinatorioUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Mock
    private SMSService service;

    @Test
    void enviarSMSAlConductor(){
        var event = new DestinatorioCambiado(
                OrdenId.of("xxxx"),
                new Destinatario("raul", "alzate", "222222")
        );
        event.setAggregateRootId("xxxxx");

        var usecase = new NotificarCambioDeDestinatorioUseCase();
        Mockito.when(repository.getEventsBy("transporte","xxxxx")).thenReturn(history());
        Mockito.when(service.enviarMensajeAConductor(Mockito.any(ConductorId.class), Mockito.anyString())).thenReturn(true);

        usecase.addRepository(repository);
        usecase.addServiceBuilder(new ServiceBuilder().addService(service));


        var isPresent = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxxx")
                .syncExecutor(usecase, new TriggeredEvent<>(event)).isPresent();
        Assertions.assertTrue(isPresent);

    }

    @Test
    void problamaConEnvioDeSMS(){
        var event = new DestinatorioCambiado(
                OrdenId.of("xxxx"),
                new Destinatario("raul", "alzate", "222222")
        );
        event.setAggregateRootId("xxxxx");

        var usecase = new NotificarCambioDeDestinatorioUseCase();
        Mockito.when(repository.getEventsBy("transporte","xxxxx")).thenReturn(history());
        Mockito.when(service.enviarMensajeAConductor(Mockito.any(ConductorId.class), Mockito.anyString())).thenReturn(false);

        usecase.addRepository(repository);
        usecase.addServiceBuilder(new ServiceBuilder().addService(service));

        var mensaje = Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor("xxxxx")
                    .syncExecutor(usecase, new TriggeredEvent<>(event));
        }).getMessage();

        Assertions.assertEquals( "No se puedo enviar el mensaje de texto", mensaje);

    }

    private List<DomainEvent> history() {
        return List.of(
                new TransporteCreado(ConductorId.of("cccc")),
                new OrdenCreada(OrdenId.of("1"), null, null)

        );
    }


}