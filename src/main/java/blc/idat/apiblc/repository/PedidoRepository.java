package blc.idat.apiblc.repository;

import blc.idat.apiblc.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value = "select p from Pedido p where p.cliente.codigo = :id")
    List<Pedido> findByCliente(@Param("id") long id);
}
