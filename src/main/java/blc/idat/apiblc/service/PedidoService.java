package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Estado;
import blc.idat.apiblc.models.Pedido;
import blc.idat.apiblc.models.Producto;
import blc.idat.apiblc.models.custom.PedidoFecha;
import blc.idat.apiblc.models.custom.PedidoUpdateCustom;
import blc.idat.apiblc.models.custom.PedidoUpdateCustom02;
import blc.idat.apiblc.models.custom.PedidoUpdateCustom03;

import java.util.List;

public interface PedidoService {

    List<Pedido> findbyCliente(Long id);

    public Pedido save(Pedido pedido);
    
    Pedido updatePedido(PedidoUpdateCustom pedidoCustom);

    List<Pedido> findPedidosById(Long id);

    List<Pedido> findAll();

    Pedido updateEstadoPed(Long id, Estado estado);

    List<Pedido> findPedidosByEstado(int id);

    List<Pedido> findPedidosByDni(String dni);

    List<Pedido> findPedidosByDate(PedidoFecha pedidoFecha);

    Pedido actualizarPedido(PedidoUpdateCustom02 pedido);

    void updatePedido(PedidoUpdateCustom03 pedidoCustom);

}
