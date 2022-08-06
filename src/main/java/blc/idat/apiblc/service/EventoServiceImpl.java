package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Evento;
import blc.idat.apiblc.models.ImagenSecundaria;
import blc.idat.apiblc.models.Producto;
import blc.idat.apiblc.models.custom.PedidoFecha;
import blc.idat.apiblc.repository.EventoRepository;
import blc.idat.apiblc.repository.ImagenSecundariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventoServiceImpl implements EventoService{

    @Autowired
    private EventoRepository eventRepo;

    @Autowired
    private ImagenSecundariaRepository imagenSecundariaRepo;

    @Override
    public List<Evento> findAll() {
        return eventRepo.findAll();
    }

    @Override
    public Evento registerEvento(Evento evento) {
        Evento e = eventRepo.save(evento);

        for (ImagenSecundaria img : e.getImagenes()){
            ImagenSecundaria imagenSec = new ImagenSecundaria(null, img.getImagen(), e.getCodigo());
            imagenSecundariaRepo.save(imagenSec);
        }

        return e;


    }

    @Override
    public List<Evento> findEventoById(Long id){
        return eventRepo.findEventoById(id);
    }

    @Override
    public List<Evento> findEventoByDate(PedidoFecha pedidoFecha) {
        return eventRepo.finEventoByDate(pedidoFecha.getFecha_inicio(), pedidoFecha.getFecha_final());
    }

    @Override
    public Evento findByDate(Date fecha) {
        return eventRepo.findByFecha((java.sql.Date) fecha);
    }

    @Override
    public void updateStatusEvent(Long id) {
        eventRepo.updateStatusEvent(id);
    }

    @Override
    public List<Evento> findEventsByState(Boolean estado) {
        return eventRepo.findEventsByState(estado);
    }
}
