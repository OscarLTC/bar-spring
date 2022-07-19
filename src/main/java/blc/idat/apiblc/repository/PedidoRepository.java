package blc.idat.apiblc.repository;

import blc.idat.apiblc.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value = "select * from pedido p \n" +
            "inner join cliente c on p.cod_cliente=c.cod_cliente \n" +
            "where c.cod_cliente = :id"
            , nativeQuery = true)
    List<Pedido> findByCliente(@Param("id") int id);
}
