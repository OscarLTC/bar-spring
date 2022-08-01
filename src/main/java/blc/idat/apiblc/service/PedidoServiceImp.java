package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Cliente;
import blc.idat.apiblc.models.Estado;
import blc.idat.apiblc.models.Pedido;
import blc.idat.apiblc.models.Producto;
import blc.idat.apiblc.models.custom.PedidoFecha;
import blc.idat.apiblc.models.custom.PedidoUpdateCustom;
import blc.idat.apiblc.models.custom.PedidoUpdateCustom02;
import blc.idat.apiblc.repository.ClienteRepository;
import blc.idat.apiblc.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImp implements PedidoService{

    @Autowired
    private PedidoRepository pedRepo;

    @Autowired
    private ClienteRepository cliRepo;

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
    public Pedido updateEstadoPed(Long id, Estado estado){
        try{
            Pedido pedidoInBd = pedRepo.findById(id).get();

            pedidoInBd.setEstado(estado);

            return pedRepo.save(pedidoInBd);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Pedido> findPedidosByEstado(int id){
        return pedRepo.findPedidosByEstado(id);
    }

    @Override
    public List<Pedido> findPedidosByDni(String dni){
        return pedRepo.findPedidosByDni(dni);
    }

    @Override
    public List<Pedido> findPedidosByDate(PedidoFecha pedidoFecha){
        return pedRepo.findPedidosByDate(pedidoFecha.getFecha_inicio() , pedidoFecha.getFecha_final());
    }

    @Override
    public Pedido actualizarPedido(PedidoUpdateCustom02 pedido){

        Pedido ped = findPedidosById(pedido.getCodigo()).get(0);

        ped.setEstado(pedido.getEstado());
        ped.setDni_recibidor(pedido.getDni());
        ped.setFecha_envio(pedido.getFecha());

        pedRepo.save(ped);
        Cliente cli = cliRepo.findById(ped.getCliente().getCodigo()).get();

        cli.setTelefono(pedido.getTelefono());
        cliRepo.save(cli);

        return pedRepo.save(ped);
    }

}
