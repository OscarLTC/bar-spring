package blc.idat.apiblc;

import blc.idat.apiblc.models.Cliente;
import blc.idat.apiblc.models.Rol;
import blc.idat.apiblc.models.Usuario;
import blc.idat.apiblc.repository.ClienteRepository;
import blc.idat.apiblc.repository.UsuarioRepository;
import blc.idat.apiblc.service.UsuarioService;
import blc.idat.apiblc.service.UsuarioServiceImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Mantengan esta anotación para trabajar con la bd real
public class ClienteJpaTest {

    private static Cliente cliente;
    @Autowired
    private ClienteRepository clienteRepository;


    @BeforeAll
    public static void Inicio(){
        cliente = new Cliente();
        System.out.println("@BeforeAll -> Inicio()");
    }

    @AfterAll
    public static void Final(){
        cliente = null;
        System.out.println("@AfterAll -> Final()");
    }

    // No usen la anotación rollback = false para no afectar los registros de la bd directamente

    @Test
    public void ClientePorIdTest(){
        assertNotNull(clienteRepository.findById(7));
        System.out.println("@Test -> ClientePorIdTest");
    }

    @Test
    public void ClientePorIdErrorTest(){
        assertNull(clienteRepository.findById(580));
        System.out.println("@Test -> ClientePorIdErrorTest");
    }

    @Test
    public void ClientePorIdUsuarioTest(){
        assertNotNull(clienteRepository.findByClient(1L));
        System.out.println("@Test -> ClientePorIdUsuarioTest");
    }
    @Test
    public void ClientePorIdUsuarioErrorTest(){
        // 3 es el id del usuario administrador actual (3/8/22) por ende no tiene un cliente
        assertNull(clienteRepository.findByClient(3L));
        System.out.println("@Test -> ClientePorIdUsuarioErrorTest");
    }

    @Test
    public void RegistrarClienteTest(){
        Usuario u = new Usuario();
        u.setCodigo(999L);

        cliente = new Cliente(0L, "Martín", "Pérez", "Hernández", "84523154", "989452156", u);

        Cliente cl = clienteRepository.save(cliente);

        assertNotNull(cl);

    }


}
