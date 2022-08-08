package blc.idat.apiblc;

import blc.idat.apiblc.models.Estado;
import blc.idat.apiblc.models.Marca;
import blc.idat.apiblc.models.Pedido;
import blc.idat.apiblc.models.Producto;
import blc.idat.apiblc.repository.ProductoRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterAll;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    public void ListadoProductoTest(){
        assertNotNull(productoRepository.findAll());
        System.out.println("@Test -> ListadoProductosTest");
    }

    @Test
    public void findByIdTest(){
        assertNotNull(productoRepository.findById(1L));
        System.out.println("@Test -> findByIDTest");
    }

    @Test
    public void findByNameTest(){
        List<Producto> p = productoRepository.findByName("Coca");
        assertNotNull(p);
        System.out.println("@Test -> findByNameTest");
    }

    @Test
    public void findByCategoryTest(){
        List<Producto> p = productoRepository.findByCategory(1L);
        assertNotNull(p);
        System.out.println("@Test -> findByCategoryTest");
    }

    @Test
    public void findByPrecioTest(){
        List<Producto> p = productoRepository.findByPrecio(3.0 , 5.0);
        assertNotNull(p);
        System.out.println("@Test -> findByPrecioTest");
    }

    @Test
    public void UpdateStatusProductTest()throws ParseException {
        assertEquals(1,productoRepository.updateStatus(1L));
        System.out.println("@Test -> UpdateStatusProductoTest()");
    }
    @Test
    public void UpdateStatusErrorTest(){
        assertEquals(0, productoRepository.updateStatus(80L));
        System.out.println("@Test -> UpdateStatusErrorTest");
    }

    @Test
    public void ActualizarProductoTest()throws ParseException{
        producto= new Producto(9L, "Barbarian (3) Barbarian LA NENA Wheat Ale Lata (269ml) Pack x 4", 75,
                "https://backusya.vtexassets.com/arquivos/ids/156684-1200-auto?v=637842791489700000&width=1200&height=auto&aspect=true",
                true, new Marca(24L,null, true, null));
        Producto p = productoRepository.save(producto);
        assertNotNull(p);
        System.out.println("@Test -> ActualizarProductoTest");
    }

    @Test
    public void findByClienteTest(){
        List<Producto> p = productoRepository.findByCliente(1);
        assertNotNull(p);
        System.out.println("@Test -> findByClienteTest");
    }
}
