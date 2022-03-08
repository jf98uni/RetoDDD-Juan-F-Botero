package co.com.sofka.domain.generic;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.pedido.value.PedidoId;

public class ClienteId extends Identity {
    private ClienteId(String id){
        super(id);
    }

    public ClienteId(){ }

    public static ClienteId of(String id) {
        return new ClienteId(id);
    }
}
