package blc.idat.apiblc.rest;


import blc.idat.apiblc.models.Evento;
import blc.idat.apiblc.models.Producto;
import blc.idat.apiblc.models.custom.PedidoFecha;
import blc.idat.apiblc.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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

    @GetMapping("/evento/{id}")
    public List<Evento> findIdEvento(@PathVariable("id")Long id) {
        return eventService.findEventoById(id);
    }

    @PostMapping("/buscar")
    public List<Evento> findEventoByDate(@RequestBody PedidoFecha pedidoFecha) {
        return eventService.findEventoByDate(pedidoFecha);
    }

    @GetMapping("/fecha/{fecha}")
    public Evento findByDate(@PathVariable("fecha") String fecha) {
        return eventService.findByDate(Date.valueOf(fecha));
    }

    @PutMapping("/update/{id}")
    public void updateStatusEvent(@PathVariable("id") Long id) {
        eventService.updateStatusEvent(id);
    }

    @GetMapping("/estado/{estado}")
    public List<Evento> findEventsByState (@PathVariable("estado") Boolean estado){
        return eventService.findEventsByState(estado);
    }
}
