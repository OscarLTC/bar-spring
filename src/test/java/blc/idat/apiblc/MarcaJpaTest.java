package blc.idat.apiblc;

import blc.idat.apiblc.models.Categoria;
import blc.idat.apiblc.models.Marca;
import blc.idat.apiblc.repository.MarcaRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Mantengan esta anotación para trabajar con la bd real
public class MarcaJpaTest {

    private static Marca marca;

    @Autowired
    private MarcaRepository marcaRepository;

    @BeforeAll
    public static void Inicio(){
        marca = new Marca();
        System.out.println("@BeforeAll -> Inicio()");
    }

    @AfterAll
    public static void Final(){
        marca = null;
        System.out.println("@AfterAll -> Final()");
    }

    // No usen la anotación rollback = false para no afectar los registros de la bd directamente

    @Test
    public void ListadoMarcasTest(){
        // Comprobando que el método no retorne null
        assertNotNull(marcaRepository.findAll());
        System.out.println("@Test -> ListadoMarcasTest");
    }

    @Test
    public void ListadoMarcasPorCategoriaTest(){
        // Comprobando que las marcas retornadas por el query sean mayores a 0
        assertNotEquals(0, marcaRepository.findByCategory(3L).size());
        System.out.println("@Test -> ListadoMarcasPorCategoriaTest");
    }

    @Test
    public void RegistrarMarcaTest(){
        // Pasando código cero para que registre y no actualice
        marca = new Marca(0L, "Fanta", true, new Categoria(1L, null));
        Marca mar = marcaRepository.save(marca);

        assertNotNull(mar);
        System.out.println("@Test -> RegistrarMarcaTest");
    }

    @Test
    public void ChangeStatusTest(){
        // Pasando un id existente esperando que retorne 1 (retorno de operación exitosa)
        assertEquals(1, marcaRepository.changeStatus(3L));

        System.out.println("@Test -> ChangeStatusTest");
    }

    @Test
    public void ChangeStatusErrorTest(){
        // Pasando un id inexistente esperando que retorne 0 (retorno de operación errónea)
        assertEquals(0, marcaRepository.changeStatus(80L));

        System.out.println("@Test -> ChangeStatusErrorTest");
    }



}
