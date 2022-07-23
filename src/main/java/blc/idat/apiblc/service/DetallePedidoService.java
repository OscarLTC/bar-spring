package blc.idat.apiblc.service;

import blc.idat.apiblc.models.DetallePedido;

import java.util.List;

public interface DetallePedidoService {
    List<DetallePedido> findByIdOrder(Long id);
}
