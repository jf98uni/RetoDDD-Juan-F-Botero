package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CambiarDestinatarioUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void cambiarDestinatorio(){
        TransporteId transporteId = TransporteId.of("cccc");
        OrdenId ordenId = OrdenId.of("1");
        Destinatario destinatario = new Destinatario( "Pedro", "Alzate",  "xxxx");
        var command = new CambiarDestinatario(transporteId, ordenId, destinatario);

        var usecase = new CambiarDestinatarioUseCase();
        Mockito.when(repository.getEventsBy("cccc")).thenReturn(history());
        usecase.addRepository(repository);



        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(transporteId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (DestinatorioCambiado)events.get(0);
        Assertions.assertEquals("1", event.getOrdenId().value());
    }

    private List<DomainEvent> history() {
        return List.of(
                new TransporteCreado(ConductorId.of("cccc")),
                new OrdenCreada(OrdenId.of("1"), null, null),
                new OrdenEntregada(OrdenId.of("1"))
        );
    }

}