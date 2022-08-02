package blc.idat.apiblc.rest;


import blc.idat.apiblc.models.Evento;
import blc.idat.apiblc.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("evento")
public class EventoController {

    @Autowired
    private EventoService eventService;

    @GetMapping("/listar")
    public List<Evento> findAll(){
        return eventService.findAll();
    }

    @PostMapping("/save")
    public Evento registerEvento(@RequestBody Evento evento){
        return eventService.registerEvento(evento);
    }

    @GetMapping("/buscar/{id}")
    public List<Evento> findIdEvento(@PathVariable("id")Long id) {
        return eventService.findEventoById(id);
    }

}
