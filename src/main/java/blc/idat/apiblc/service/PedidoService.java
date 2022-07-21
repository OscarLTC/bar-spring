package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Pedido;

import java.util.List;

public interface PedidoService {

    List<Pedido> findbyCliente(Long id);

    public Pedido save(Pedido pedido);
}
