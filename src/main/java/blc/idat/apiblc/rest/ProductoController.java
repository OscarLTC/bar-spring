package blc.idat.apiblc.rest;


import blc.idat.apiblc.models.Producto;
import blc.idat.apiblc.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("producto")
public class ProductoController {

    @Autowired
    private ProductoService proService;

    @GetMapping("/all")
    public List<Producto> findAll(){
        return proService.findAll();
    }

    @GetMapping("/all/{id}")
    public List<Producto> findByCliente(@PathVariable("id") int id){
        return proService.findByCliente(id);
    }
}
