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
    public List<Pedido> findbyCliente(int id) {
        List<Pedido> finalList = new ArrayList<Pedido>();

        List<Pedido> allPedidos = pedRepo.findAll();
        List<Pedido> clientePedidos = pedRepo.findByCliente(id);

        finalList = Stream.concat(clientePedidos.stream(), allPedidos.stream()).collect(Collectors.toList());
        finalList = (ArrayList<Pedido>) finalList.stream().distinct().collect(Collectors.toList());
        return finalList;
    }
}
