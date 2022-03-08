package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.ProductoId;
import co.com.sofka.domain.pedido.value.CantidadPedida;
import co.com.sofka.domain.pedido.value.MetodoDePago;
import co.com.sofka.domain.generic.Precio;
import co.com.sofka.domain.pedido.value.PrecioNeto;
import co.com.sofka.domain.pedido.value.PrecioPedido;

public class VentaGenerada extends DomainEvent {
    private final MetodoDePago metodoDePago;
    private final Precio precio;
    private final PrecioNeto precioNeto;
    private final ProductoId productoId;
    private final CantidadPedida cantidadPedida;
    private final PrecioPedido precioPedido;
    public VentaGenerada(MetodoDePago metodoDePago, Precio precio, PrecioNeto precioNeto, ProductoId productoId, CantidadPedida cantidadPedida, PrecioPedido precioPedido) {
        super("pedido.ventagenerada");
        this.metodoDePago = metodoDePago;
        this.precio = precio;
        this.precioNeto = precioNeto;
        this.productoId = productoId;
        this.cantidadPedida = cantidadPedida;
        this.precioPedido = precioPedido;
    }

    public MetodoDePago getMetodoDePago() {
        return metodoDePago;
    }

    public Precio getPrecio() {
        return precio;
    }

    public PrecioNeto getPrecioNeto() {
        return precioNeto;
    }

    public CantidadPedida getCantidadPedida() {
        return cantidadPedida;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public PrecioPedido getPrecioPedido() {
        return precioPedido;
    }
}
