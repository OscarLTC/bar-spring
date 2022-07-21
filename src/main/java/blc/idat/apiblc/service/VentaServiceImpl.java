package blc.idat.apiblc.service;

import blc.idat.apiblc.models.*;
import blc.idat.apiblc.repository.ClienteRepository;
import blc.idat.apiblc.repository.DetallePedidoRepository;
import blc.idat.apiblc.repository.EstadoRepository;
import blc.idat.apiblc.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class VentaServiceImpl implements VentaService{

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public void saveVenta(Venta venta) {

        Pedido pedido = new Pedido();
        pedido.setCliente(clienteRepository.findById(venta.getIdusuario()));
        pedido.setPrecio_total(venta.getDetalle().stream().mapToDouble(detalle -> detalle.getSubtotal()).sum());
        pedido.setFecha_solicitud(new Date(System.currentTimeMillis()));
        pedido.setEstado(estadoRepository.findEstadoById(venta.getEstado()));
        pedido.setDni_recibidor(venta.getDni_receptor());
        pedido.setFecha_envio(venta.getFecha_envio());

        pedidoRepository.save(pedido);

        for(DetalleProducto detalle : venta.getDetalle()){
            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setIdproducto(detalle.getIdproducto());
            detallePedido.setIdpedido((long) pedidoRepository.findLastOrder());
            detallePedido.setSubtotal(detalle.getSubtotal());
            detallePedido.setCantidad(detalle.getCantidad());

            detallePedidoRepository.save(detallePedido);
        }
    }
}
