package blc.idat.apiblc;

import blc.idat.apiblc.models.Marca;
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

    @Test
    public void RegistrarProductoTest(){
        producto = new Producto(0L, "Viva Backus Combo 2 (450ml) Pack x 15", 30,
                "https://backusya.vtexassets.com/arquivos/ids/156194-800-auto?v=637747462819770000&width=800&height=auto&aspect=true",
                true, new Marca(25L,null, true, null));

        Producto pro = productoRepository.save(producto);
        assertNotNull(pro);
        System.out.println("@Test -> RegistrarProductoTest()");

    }

}
