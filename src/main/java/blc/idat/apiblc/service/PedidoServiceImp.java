package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Estado;
import blc.idat.apiblc.models.Pedido;
import blc.idat.apiblc.models.PedidoUpdateCustom;
import blc.idat.apiblc.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    public Pedido updatePedido(PedidoUpdateCustom pedidoCustom) {
        try{
            Pedido pedidoInBd = pedRepo.findById(pedidoCustom.getCod_pedido()).get();
            pedidoInBd.setDni_recibidor(pedidoCustom.getDni());
            // Si el pedido está como pendiente, se guarda
            if (pedidoInBd.getEstado().getNombre().equals("Pendiente")){
                //pedidoCustom.setFecha(new Date( pedidoCustom.getFecha().getYear(), pedidoCustom.getFecha().getMonth(), pedidoCustom.getFecha().getDate()+5 ));
                pedidoInBd.setFecha_envio(pedidoCustom.getFecha());
                pedidoInBd.setEstado(new Estado(2, "Postergado"));
                // Pero si la fecha entrante es diferente a la fecha que está en pedido y el estado ya es Postergado, entonces no se hace la actualización
            } else if (!pedidoInBd.getFecha_envio().toString().equals(pedidoCustom.getFecha().toString()) &&
                    pedidoInBd.getEstado().getNombre().equals("Postergado")){
                throw new Exception();
            }

            return pedRepo.save(pedidoInBd);
        } catch (Exception e){
            return null;
        }

    }


}
