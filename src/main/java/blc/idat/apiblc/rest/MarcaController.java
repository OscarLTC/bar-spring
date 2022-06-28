package blc.idat.apiblc.rest;

import blc.idat.apiblc.models.Marca;
import blc.idat.apiblc.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping("/all")
    public List<Marca> findAll(){
        return marcaService.findAll();
    }
}
