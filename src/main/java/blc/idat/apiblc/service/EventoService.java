package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Evento;
import blc.idat.apiblc.models.Producto;
import blc.idat.apiblc.models.custom.PedidoFecha;
import blc.idat.apiblc.models.custom.PedidoUpdateCustom;

import java.util.Date;
import java.util.List;

public interface EventoService {

    List<Evento> findAll();

    Evento registerEvento(Evento evento);

    List<Evento> findEventoById(Long id);

    List<Evento> findEventoByDate(PedidoFecha pedidoFecha);

    Evento findByDate(Date fecha);

    void updateStatusEvent(Long id);

    List<Evento> findEventsByState(Boolean estado);
}
