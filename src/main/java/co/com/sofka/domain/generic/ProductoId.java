package co.com.sofka.domain.generic;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.pedido.value.PedidoId;

public class ProductoId extends Identity {
    private ProductoId(String id){
        super(id);
    }

    public ProductoId(){ }

    public static ProductoId of(String id) {
        return new ProductoId(id);
    }
}
