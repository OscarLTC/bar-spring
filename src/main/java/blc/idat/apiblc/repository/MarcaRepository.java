package blc.idat.apiblc.repository;

import blc.idat.apiblc.models.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

    @Query("select m from Marca m where m.categoria.codigo = :id")
    List<Marca> findByCategory(@Param("id") Long id);

}
