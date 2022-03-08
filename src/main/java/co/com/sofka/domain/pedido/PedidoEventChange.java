package co.com.sofka.domain.pedido;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.generic.ProductoId;
import co.com.sofka.domain.pedido.event.PedidoCreado;
import co.com.sofka.domain.pedido.event.VentaGenerada;
import co.com.sofka.domain.generic.Fecha;
import co.com.sofka.domain.pedido.value.CantidadPedida;
import co.com.sofka.domain.pedido.value.PrecioPedido;
import co.com.sofka.domain.pedido.value.VentaId;

import java.util.HashSet;

public class PedidoEventChange extends EventChange {
    public PedidoEventChange(Pedido pedido) {

        apply((PedidoCreado event) -> {
            //Agregar reglas de dominio
            pedido.clienteId = event.getClienteId();
            pedido.productoPedidos = new HashSet<>();
        });

        apply((VentaGenerada event) -> {
            //Agregar reglas de dominio
            VentaId ventaId = new VentaId();
            Fecha fecha = new Fecha();

            pedido.venta = new Venta(
                    ventaId, fecha, event.getMetodoDePago(), event.getPrecio(), event.getPrecioNeto()
            );
            var cantidadPedida = event.getCantidadPedida();
            PrecioPedido precioPedido = event.getPrecioPedido().ajustarPrecio(
                    new PrecioPedido(pedido.venta.precio().value()*cantidadPedida.value())
            );
            pedido.venta.calcularPrecio(event.getProductoId(),  cantidadPedida,  precioPedido);


        });
    }
}
