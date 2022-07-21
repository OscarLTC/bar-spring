package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Pedido;
import blc.idat.apiblc.models.PedidoUpdateCustom;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface PedidoService {

    List<Pedido> findbyCliente(Long id);

    Pedido updatePedido(PedidoUpdateCustom pedidoCustom);

}
