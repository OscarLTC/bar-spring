package blc.idat.apiblc.repository;

import blc.idat.apiblc.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    @Query(value = "select * from estadospedido e where e.cod_pedido_estado = :id", nativeQuery = true)
    Estado findEstadoById(int id);
}
