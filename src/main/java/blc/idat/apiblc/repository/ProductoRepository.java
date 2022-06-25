package blc.idat.apiblc.repository;

import blc.idat.apiblc.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Query(value = "select p.cod_producto, p.descripcion, p.precio, p.imagen, p.estado, p.cod_marca \n" +
            "from producto p inner join detallepedido d\n" +
            "on p.cod_producto = d.cod_producto inner join\n" +
            "pedido pe on pe.cod_pedido = d.cod_pedido \n" +
            "inner join cliente c on pe.cod_cliente = c.cod_cliente\n" +
            "where c.cod_cliente = :id\n" +
            "group by p.cod_producto \n" +
            "having SUM(d.cantidad)\n" +
            "order by SUM(d.cantidad) desc \n", nativeQuery = true)
    List<Producto> findByCliente(@Param("id") int id);
}
