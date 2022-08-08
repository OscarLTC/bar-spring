package blc.idat.apiblc.repository;

import blc.idat.apiblc.models.ImagenSecundaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ImagenSecundariaRepository extends JpaRepository<ImagenSecundaria, Long> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "delete from ImagenSecundaria i where i.cod_evento = :codigo")
    void deleteImageForEvent(@Param("codigo") Long codigo);

}
