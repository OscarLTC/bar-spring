package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Pedido;
import blc.idat.apiblc.models.custom.PedidoUpdateCustom;

import java.util.List;

public interface PedidoService {

    List<Pedido> findbyCliente(Long id);

    public Pedido save(Pedido pedido);
    
    Pedido updatePedido(PedidoUpdateCustom pedidoCustom);

}
