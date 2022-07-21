package blc.idat.apiblc.rest;

import blc.idat.apiblc.models.Pedido;
import blc.idat.apiblc.models.Venta;
import blc.idat.apiblc.service.PedidoService;
import blc.idat.apiblc.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/all/{id}")
    public List<Pedido> findByCliente(@PathVariable("id") Long id){
        return pedService.findbyCliente(id);
    }

    @PostMapping("/venta")
    public ResponseEntity<?> add(@RequestBody Venta venta){
        ventaService.saveVenta(venta);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
