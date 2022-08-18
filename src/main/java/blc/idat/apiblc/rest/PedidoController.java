package blc.idat.apiblc.rest;

import blc.idat.apiblc.models.DetallePedido;
import blc.idat.apiblc.models.Estado;
import blc.idat.apiblc.models.Pedido;
import blc.idat.apiblc.models.Producto;
import blc.idat.apiblc.models.custom.*;
import blc.idat.apiblc.service.DetallePedidoService;
import blc.idat.apiblc.service.PedidoService;
import blc.idat.apiblc.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedService;

    @Autowired
    private  VentaService ventaService;

    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping("/all/{id}")
    public List<Pedido> findByCliente(@PathVariable("id") Long id){
        return pedService.findbyCliente(id);
    }

   @PostMapping("/venta")
    public ResponseEntity<?> add(@RequestBody Venta venta){
        ventaService.saveVenta(venta);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PutMapping("/actualizar/{id}")
    public Pedido updatePedido(@PathVariable("id") Long id,@RequestBody PedidoUpdateCustom pedidoUpdateCustom){
        pedidoUpdateCustom.setCod_pedido(id);
        return pedService.updatePedido(pedidoUpdateCustom);

    }

    @GetMapping("/buscar/{id}")
    public List<Pedido> findPedido(@PathVariable("id")Long id) {
        return pedService.findPedidosById(id);
    }

    @GetMapping("/listarProductos/{id}")
    public List<DetallePedido> findAllProducts(@PathVariable("id")Long id){
        return detallePedidoService.findByIdOrder(id);

    }

    @GetMapping("/all")
    public List<Pedido> findAll(){ return pedService.findAll();}

    @PutMapping("/estado/{id}")
    public Pedido updateEstadoPed(@PathVariable("id") Long id,@RequestBody Estado estado){
        return pedService.updateEstadoPed(id, estado);
    }

    @GetMapping("/estadox/{id}")
    public List<Pedido> findPedidosByEstado(@PathVariable("id") int id){
        return pedService.findPedidosByEstado(id);
    }

    @GetMapping("/dni/{dni}")
    public List<Pedido> findPedidosByDni(@PathVariable("dni") String dni){
        return pedService.findPedidosByDni(dni);
    }

    @PostMapping("/fechas")
    public List<Pedido> findPedidosByDate(@RequestBody PedidoFecha pedidoFecha){
        return  pedService.findPedidosByDate(pedidoFecha);
    }

    @PutMapping("/actualizarp")
    public Pedido actualizarPedido(@RequestBody PedidoUpdateCustom02 ped){
        return pedService.actualizarPedido(ped);
    }

    @PutMapping("/actualizarp2")
    public void updatePedido(@RequestBody PedidoUpdateCustom03 ped){
        pedService.updatePedido(ped);
    }

}
