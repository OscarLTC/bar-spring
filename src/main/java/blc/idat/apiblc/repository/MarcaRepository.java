package blc.idat.apiblc.repository;

import blc.idat.apiblc.models.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

    @Query("select m from Marca m where m.categoria.codigo = :id")
    List<Marca> findByCategory(@Param("id") Long id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update marca m set m.estado = false where m.cod_marca = :id", nativeQuery = true)
    Integer changeStatus(@Param("id") Long id);

}
