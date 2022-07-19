package blc.idat.apiblc.rest;

import blc.idat.apiblc.models.Pedido;
import blc.idat.apiblc.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedService;

    @GetMapping("/all/{id}")
    public List<Pedido> findByCliente(@PathVariable("id") int id){
        return pedService.findbyCliente(id);
    }
}
