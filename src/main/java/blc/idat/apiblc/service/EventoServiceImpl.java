package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Evento;
import blc.idat.apiblc.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
