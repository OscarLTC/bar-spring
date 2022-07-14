package blc.idat.apiblc.rest;


import blc.idat.apiblc.models.Precio;
import blc.idat.apiblc.models.Producto;
import blc.idat.apiblc.service.ProductoService;
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

    @PutMapping("/update/{id}")
    public Producto updateProduct(@RequestBody Producto pro, @PathVariable("id") Long id ){
        return proService.updateProduct(pro, id);
    }

    @GetMapping("/nombre/{name}")
    public List<Producto> findByName(@PathVariable("name") String name){
        return proService.findByName(name);
    }

    @PostMapping("/precio")
    public List<Producto> findByPrecio(@RequestBody Precio precio){
        return proService.findByPrecio(precio);
    }

    @GetMapping("/categoria/{id}")
    public List<Producto> findByCategory(@PathVariable("id") Long id){
        return proService.findByCategory(id);
    }

    @GetMapping("/marca/{id}")
    public List<Producto> findByBrand(@PathVariable("id") Long id){
        return proService.findByBrand(id);
    }



}
