package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Evento;

import java.util.List;

public interface EventoService {

    List<Evento> findAll();

    Evento registerEvento(Evento evento);
}
