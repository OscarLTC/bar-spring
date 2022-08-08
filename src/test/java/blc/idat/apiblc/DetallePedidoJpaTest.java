package blc.idat.apiblc;

import blc.idat.apiblc.models.DetallePedido;
import blc.idat.apiblc.repository.DetallePedidoRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Mantengan esta anotación para trabajar con la bd real
public class DetallePedidoJpaTest {

    private static DetallePedido detallePedido;

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @BeforeAll
    public static void Inicio(){
        detallePedido = new DetallePedido();
        System.out.println("@BeforeAll -> Inicio()");
    }

    @AfterAll
    public static void Final(){
        detallePedido = null;
        System.out.println("@AfterAll -> Final()");
    }

    // No usen la anotación rollback = false para no afectar los registros de la bd directamente

    @Test
    public void PlantillaTest(){
        System.out.println("@Test -> PlantillaTest");
    }

    @Test
    public void saveTest(){
        detallePedido.setIdproducto(6L);
        detallePedido.setIdpedido(45L);
        detallePedido.setSubtotal(4.0);
        detallePedido.setCantidad(1);
        DetallePedido detallePedido1 = detallePedidoRepository.save(detallePedido);
        assertNotNull(detallePedido1);
        System.out.println("@Test -> saveTest");
    }

    @Test
    public void findByIdOrderTest(){
        assertNotNull(detallePedidoRepository.findByIdOrder(45L));
        System.out.println("@Test -> findByIdTest");
    }
}
