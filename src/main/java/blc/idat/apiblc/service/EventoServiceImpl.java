package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Evento;
import blc.idat.apiblc.models.custom.PedidoFecha;
import blc.idat.apiblc.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventoServiceImpl implements EventoService{

    @Autowired
    private EventoRepository eventRepo;

    @Override
    public List<Evento> findAll() {
        return eventRepo.findAll();
    }

    @Override
    public Evento registerEvento(Evento evento) {
        return eventRepo.save(evento);
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


}
