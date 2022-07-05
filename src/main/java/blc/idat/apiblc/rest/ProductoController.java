package blc.idat.apiblc.rest;


import blc.idat.apiblc.models.Producto;
import blc.idat.apiblc.service.ProductoService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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

    @GetMapping("/{id}")
    public Optional<Producto> findById(@PathVariable Long id){
        return proService.findById(id);
    }

    @PostMapping("/save")
    public Producto registerProduct(@RequestBody Producto pro){
        return proService.registerProduct(pro);
    }



}
