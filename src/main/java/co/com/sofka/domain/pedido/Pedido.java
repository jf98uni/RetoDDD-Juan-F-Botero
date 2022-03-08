package co.com.sofka.domain.pedido;

import co.com.sofka.domain.generic.*;
import co.com.sofka.domain.pedido.event.PedidoCreado;
import co.com.sofka.domain.pedido.event.VentaGenerada;
import co.com.sofka.domain.pedido.value.*;

import java.util.List;
import java.util.Set;

public class Pedido extends AggregateEvent<PedidoId> {
    protected Venta venta;
    protected Set<ProductoPedido> productoPedidos;//TODO: que comportamiento administraria estos estados
    protected ClienteId clienteId;

    public Pedido(PedidoId pedidoId, ClienteId clienteId) {
        super(pedidoId);
        subscribe(new PedidoEventChange(this));
        appendChange(new PedidoCreado(clienteId)).apply();
    }


    private Pedido(PedidoId pedidoId){
        super(pedidoId);
        subscribe(new PedidoEventChange(this));
    }


    public static Pedido from(PedidoId pedidoId, List<DomainEvent> eventList){
        Pedido pedido = new Pedido(pedidoId);
        eventList.forEach(pedido::applyEvent);

        return pedido;
    }

    public void generarVenta(ProductoId productoId, CantidadPedida cantidadPedida, MetodoDePago metodoDePago, Precio precio, PrecioNeto precioNeto){
        var precioPedido = new PrecioPedido(0D);
        appendChange(new VentaGenerada( metodoDePago,  precio,  precioNeto, productoId, cantidadPedida, precioPedido)).apply();
    }


    public Set<ProductoPedido> productoPedidos() {
        return productoPedidos;
    }

    public Venta venta() {
        return venta;
    }
}
