package blc.idat.apiblc.rest;


import blc.idat.apiblc.models.Evento;
import blc.idat.apiblc.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
