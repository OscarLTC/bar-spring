package blc.idat.apiblc.rest;

import blc.idat.apiblc.models.DetallePedido;
import blc.idat.apiblc.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("detalle")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping("/order/{id}")
    public List<DetallePedido> findByIdOrder(@PathVariable("id")int id){
        return detallePedidoService.findByIdOrder((long) id);
    }
}
