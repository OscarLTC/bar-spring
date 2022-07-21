package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Pedido;
import blc.idat.apiblc.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PedidoServiceImp implements PedidoService{

    @Autowired
    private PedidoRepository pedRepo;

    @Override
    public List<Pedido> findbyCliente(Long id) {
        return pedRepo.findByCliente(id);
    }

    @Override
    public Pedido save(Pedido pedido) {
        return null;
    }
}
