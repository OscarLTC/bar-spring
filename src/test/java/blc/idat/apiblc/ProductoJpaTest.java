package blc.idat.apiblc;

import blc.idat.apiblc.models.Producto;
import blc.idat.apiblc.repository.ProductoRepository;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Mantengan esta anotación para trabajar con la bd real
public class ProductoJpaTest {

    private static Producto producto;

    @Autowired
    private ProductoRepository productoRepository;

    @BeforeAll
    public static void Inicio(){
        producto = new Producto();
        System.out.println("@BeforeAll -> Inicio()");
    }

    @AfterAll
    public static void Final(){
        producto = null;
        System.out.println("@AfterAll -> Final()");
    }

    // No usen la anotación rollback = false para no afectar los registros de la bd directamente

    @Test
    public void ProductoPorMarcaTest(){
        long cod = 2;
        List<Producto> pro = productoRepository.findByBrand(cod);
        assertNotNull(pro);
        System.out.println("@Test -> ProductoPorMarcaTest()");
    }

}
