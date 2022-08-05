package blc.idat.apiblc.repository;

import blc.idat.apiblc.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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


    @Query(value="select * from producto p\n" +
            "where p.descripcion  like CONCAT('%', :name, '%') ", nativeQuery=true)
    List<Producto> findByName(@Param("name") String name);

    @Query(value = "select * from producto p\n" +
            "where p.precio BETWEEN :min and :max", nativeQuery = true)
    List<Producto> findByPrecio(@Param("min") double min, @Param("max") double max);


    @Query(value = "SELECT p.cod_producto, p.descripcion, p.precio, p.imagen, p.estado, p.cod_marca \n" +
            "FROM producto p\n" +
            "inner join marca m on p.cod_marca = m.cod_marca\n" +
            "where m.cod_categoria = :id", nativeQuery = true)
    List<Producto> findByCategory(@Param("id") Long id);

    @Query(value = "select p from Producto p where p.marca.codigo = :id")
    List<Producto> findByBrand(@Param("id") Long id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update producto p set p.estado = !p.estado where p.cod_producto = :id", nativeQuery = true)
    Integer updateStatus(@Param("id") Long id);

    @Query(value = "select p from Producto p where p.estado = :estado")
    List<Producto> findProductsByState(@Param("estado") Boolean estado);

}
