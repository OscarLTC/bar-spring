package blc.idat.apiblc.rest;

import blc.idat.apiblc.models.Estado;
import blc.idat.apiblc.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping("/all")
    public List<Estado> findAll(){
        return estadoService.findAll();
    }

}
