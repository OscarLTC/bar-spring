package blc.idat.apiblc.repository;

import blc.idat.apiblc.models.Evento;
import blc.idat.apiblc.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    @Query(value = "select * from evento where cod_evento=:id", nativeQuery = true)
    List<Evento> findEventoById(@Param("id") long id);

    @Query(value = "select * from evento e\n" +
            "where e.fecha BETWEEN :inicio and :fin", nativeQuery = true)
    List<Evento> finEventoByDate(@Param("inicio") Date inicio, @Param("fin") Date fin);

    @Query(value = "SELECT * FROM evento e\n" +
            "where e.fecha = :fecha", nativeQuery = true)
    Evento findByFecha(@Param("fecha") Date fecha);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update evento e set e.estado = !e.estado where e.cod_evento = :id", nativeQuery = true)
    void updateStatusEvent(@Param("id") Long id);
}
