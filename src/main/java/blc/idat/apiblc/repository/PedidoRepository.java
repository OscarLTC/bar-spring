package blc.idat.apiblc.repository;

import blc.idat.apiblc.models.Pedido;
import blc.idat.apiblc.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value = "select p from Pedido p where p.cliente.codigo = :id")
    List<Pedido> findByCliente(@Param("id") long id);


    @Query(value = "select * from pedido where cod_pedido = :id", nativeQuery = true)
    List<Pedido> findPedidosById(@Param("id") long id);

    @Query(value = "select p from Pedido p where p.estado.codigo = :id")
    List<Pedido> findPedidosByEstado(@Param("id") int id);

    @Query(value = "select p from Pedido p where p.cliente.dni = :dni")
    List<Pedido> findPedidosByDni(@Param("dni") String dni);

    @Query(value = "select * from pedido p\n" +
            "where p.fecha_envio BETWEEN :inicio and :fin", nativeQuery = true)
    List<Pedido> findPedidosByDate(@Param("inicio") Date inicio, @Param("fin") Date fin);

}
