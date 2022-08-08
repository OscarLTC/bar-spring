package blc.idat.apiblc;

import blc.idat.apiblc.models.Rol;
import blc.idat.apiblc.models.Usuario;
import blc.idat.apiblc.repository.UsuarioRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Mantengan esta anotación para trabajar con la bd real
public class UsuarioJpaTest {

    private static Usuario usuario;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeAll
    public static void Inicio(){
        usuario = new Usuario();
        System.out.println("@BeforeAll -> Inicio()");
    }

    @AfterAll
    public static void Final(){
        usuario = null;
        System.out.println("@AfterAll -> Final()");
    }

    // No usen la anotación rollback = false para no afectar los registros de la bd directamente

    @Test
    public void PlantillaTest(){
        System.out.println("@Test -> PlantillaTest");
    }


    @Test
    public  void saveTest() {
        usuario.setCorreo("joseperez@gmail.com");
        usuario.setContrasena("123456");
        usuario.setRol(new Rol(1L, "ADMIN"));
        Usuario user = usuarioRepository.save(usuario);
        assertNotNull(user);
        System.out.println("@Test -> saveTest");
    }

    @Test
    public void findByCorreoTest() {
        Usuario usuario = usuarioRepository.searchByEmail("oscartaco2003@gmail.com");
        assertNotNull(usuario);
        System.out.println("@Test -> findByCorreoTest");
    }

    @Test
    public void findAllTest() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        assertNotNull(usuarios);
        System.out.println("@Test -> findAllTest");
    }
}
