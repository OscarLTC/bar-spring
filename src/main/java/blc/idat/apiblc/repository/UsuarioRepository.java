package blc.idat.apiblc.repository;

import blc.idat.apiblc.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select u from Usuario u where u.correo like :correo")
    Usuario searchByEmail(@Param("correo") String correo);



}
