package blc.idat.apiblc.rest;

import blc.idat.apiblc.models.Marca;
import blc.idat.apiblc.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/byCategory/{id}")
    public List<Marca> findByCategory(@PathVariable Long id){
        return marcaService.findByCategory(id);
    }

    /*No hacer prueba a menos que seas el encargado según la planificación en scrum*/
    @PostMapping("/save")
    public Marca registerMarca(@RequestBody Marca marca){
        return marcaService.registerMarca(marca);
    }

    @PutMapping("/estado/{id}")
    public void changeStatus(@PathVariable Long id){
        marcaService.changeStatus(id);
    }

}
