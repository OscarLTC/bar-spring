package blc.idat.apiblc.repository;

import blc.idat.apiblc.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    @Query(value = "select * from evento where cod_evento=:id", nativeQuery = true)
    List<Evento> findEventoById(@Param("id") long id);

}
