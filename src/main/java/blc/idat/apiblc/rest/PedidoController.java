package blc.idat.apiblc.rest;

import blc.idat.apiblc.models.Pedido;
import blc.idat.apiblc.models.PedidoUpdateCustom;
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
    public List<Pedido> findByCliente(@PathVariable("id") Long id){
        return pedService.findbyCliente(id);
    }

    @PutMapping("/actualizar/{id}")
    public Pedido updatePedido(@PathVariable("id") Long id,@RequestBody PedidoUpdateCustom pedidoUpdateCustom){
        pedidoUpdateCustom.setCod_pedido(id);
        return pedService.updatePedido(pedidoUpdateCustom);
    }
}
