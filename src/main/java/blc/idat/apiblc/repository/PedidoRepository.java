package blc.idat.apiblc.repository;

import blc.idat.apiblc.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value = "select p from Pedido p where p.cliente.codigo = :id")
    List<Pedido> findByCliente(@Param("id") long id);
    @Query(value = "select p.cod_pedido from pedido p\n" +
            "ORDER BY p.cod_pedido desc\n" +
            "LIMIT 1", nativeQuery = true)
    int findLastOrder();
}
