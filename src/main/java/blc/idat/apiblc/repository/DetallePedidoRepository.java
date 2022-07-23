package blc.idat.apiblc.repository;

import blc.idat.apiblc.models.DetallePedido;
import blc.idat.apiblc.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {

    @Query(value = "select * from detallepedido where cod_pedido = :id", nativeQuery = true)
    List<DetallePedido> findByIdOrder(@Param("id") Long id);
}
