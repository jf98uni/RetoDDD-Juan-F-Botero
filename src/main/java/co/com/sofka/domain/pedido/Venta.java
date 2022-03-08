package co.com.sofka.domain.pedido;

import co.com.sofka.domain.generic.Fecha;
import co.com.sofka.domain.generic.Precio;
import co.com.sofka.domain.generic.ProductoId;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.pedido.value.*;

public class Venta extends Entity<VentaId> {
    private final Fecha fecha;
    private final MetodoDePago metodoDePago;
    private final Precio precio;
    private final PrecioNeto precioNeto;

    private ProductoPedido productoPedido;

    public Venta(VentaId entityId, Fecha fecha, MetodoDePago metodoDePago, Precio precio, PrecioNeto precioNeto) {
        super(entityId);
        this.fecha = fecha;
        this.metodoDePago = metodoDePago;
        this.precio = precio;
        this.precioNeto = precioNeto;
    }


    public void calcularPrecio(ProductoId productoId, CantidadPedida cantidadPedida, PrecioPedido precioPedido){
        this.productoPedido = new ProductoPedido(productoId, cantidadPedida, precioPedido);
    }

    public Fecha fecha() {
        return fecha;
    }

    public MetodoDePago metodoDePago() {
        return metodoDePago;
    }

    public Precio precio() {
        return precio;
    }

    public PrecioNeto precioNeto() {
        return precioNeto;
    }

    public ProductoPedido productoPedido() {
        return productoPedido;
    }
}
