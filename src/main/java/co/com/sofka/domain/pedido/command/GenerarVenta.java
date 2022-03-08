package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.Precio;
import co.com.sofka.domain.generic.ProductoId;
import co.com.sofka.domain.pedido.value.CantidadPedida;
import co.com.sofka.domain.pedido.value.MetodoDePago;
import co.com.sofka.domain.pedido.value.PedidoId;
import co.com.sofka.domain.pedido.value.PrecioNeto;

public class GenerarVenta extends Command {
    private final PedidoId pedidoId;
    private final MetodoDePago metodoDePago;
    private final Precio precio;
    private final PrecioNeto precioNeto;
    private final ProductoId productoId;
    private final CantidadPedida cantidadPedida;
    public GenerarVenta(PedidoId pedidoId, MetodoDePago metodoDePago, Precio precio, PrecioNeto precioNeto, ProductoId productoId, CantidadPedida cantidadPedida) {
        this.pedidoId = pedidoId;
        this.metodoDePago = metodoDePago;
        this.precio = precio;
        this.precioNeto = precioNeto;
        this.productoId = productoId;
        this.cantidadPedida = cantidadPedida;
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

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public CantidadPedida getCantidadPedida() {
        return cantidadPedida;
    }
}

