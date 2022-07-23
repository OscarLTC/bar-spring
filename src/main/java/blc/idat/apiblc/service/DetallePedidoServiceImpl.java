package blc.idat.apiblc.service;

import blc.idat.apiblc.models.DetallePedido;
import blc.idat.apiblc.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService{
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Override
    public List<DetallePedido> findByIdOrder(Long id) {
        return detallePedidoRepository.findByIdOrder(id);
    }
}
