package co.com.sofka.domain.pedido.value;

import co.com.sofka.domain.generic.ProductoId;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ProductoPedido implements ValueObject<ProductoPedido.Props> {
    private final ProductoId productoId;
    private final CantidadPedida cantidadPedida;
    private final PrecioPedido precioPedido;

    public ProductoPedido(ProductoId productoId, CantidadPedida cantidadPedida, PrecioPedido precioPedido) {
        this.productoId = Objects.requireNonNull(productoId, "El id del producto no puede ser null");
        this.cantidadPedida = Objects.requireNonNull(cantidadPedida);
        this.precioPedido = Objects.requireNonNull(precioPedido);
    }


    @Override
    public Props value() {
        return new Props() {
            @Override
            public ProductoId productoId() {
                return productoId;
            }

            @Override
            public CantidadPedida cantidadPedida() {
                return cantidadPedida;
            }

            @Override
            public PrecioPedido precioPedido() {
                return precioPedido;
            }
        };
    }

    public interface Props{
        ProductoId productoId();
        CantidadPedida cantidadPedida();
        PrecioPedido precioPedido();
    }
}
