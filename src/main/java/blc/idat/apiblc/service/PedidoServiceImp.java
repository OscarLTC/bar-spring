package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Estado;
import blc.idat.apiblc.models.Pedido;
import blc.idat.apiblc.models.Producto;
import blc.idat.apiblc.models.custom.PedidoUpdateCustom;
import blc.idat.apiblc.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Pedido> findPedidosById(Long id) {
        return pedRepo.findPedidosById(id);
    }

    @Override
    public List<Pedido> findAll(){ return pedRepo.findAll();}

    @Override
    public Pedido updateEstadoPed(Pedido pedido){
        try{
            Pedido pedidoInBd = pedRepo.findById(pedido.getCod_pedido()).get();
            if (pedido.getEstado().getCodigo()==1&&pedido.getEstado().getNombre().equals("Pendiente")){
                pedidoInBd.setEstado(new Estado(1, "Pendiente"));
            } else if (pedido.getEstado().getCodigo()==2&&pedido.getEstado().getNombre().equals("Postergado")){
                pedidoInBd.setEstado(new Estado(2, "Postergado"));
            } else if (pedido.getEstado().getCodigo()==3&&pedido.getEstado().getNombre().equals("Entregado")){
                pedidoInBd.setEstado(new Estado(3, "Entregado"));
            } else if (pedido.getEstado().getCodigo()==4&&pedido.getEstado().getNombre().equals("Anulado")){
                pedidoInBd.setEstado(new Estado(4, "Anulado"));
            }else {
                throw new Exception();
            }
            return pedRepo.save(pedidoInBd);
        }catch (Exception e){
            return null;
        }
    }
}
