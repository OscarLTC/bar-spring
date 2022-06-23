package blc.idat.apiblc.rest;


import blc.idat.apiblc.models.Producto;
import blc.idat.apiblc.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("producto")
public class ProductoController {

    @Autowired
    private ProductoService proService;

    @GetMapping
    public List<Producto> findAll(){
        return proService.findAll();
    }

}
