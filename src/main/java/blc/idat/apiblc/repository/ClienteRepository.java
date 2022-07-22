package blc.idat.apiblc.repository;

import blc.idat.apiblc.models.Cliente;
import blc.idat.apiblc.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("select c from Cliente c where c.usuario.codigo = :codigo")
    Cliente findByClient(@Param("codigo") Long codigo);

    @Query(value = "select * from cliente c where c.cod_cliente = :id", nativeQuery = true)
    Cliente findById(int id);
}
