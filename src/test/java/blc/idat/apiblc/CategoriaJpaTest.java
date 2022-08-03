package blc.idat.apiblc;

import blc.idat.apiblc.models.Categoria;
import blc.idat.apiblc.repository.CategoriaRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Mantengan esta anotación para trabajar con la bd real
public class CategoriaJpaTest {

    private static Categoria categoria;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @BeforeAll
    public static void Inicio(){
        categoria = new Categoria();
        System.out.println("@BeforeAll -> Inicio()");
    }

    @AfterAll
    public static void Final(){
        categoria = null;
        System.out.println("@AfterAll -> Final()");
    }

    // No usen la anotación rollback = false para no afectar los registros de la bd directamente

    @Test
    public void ListadoCategoriasTest(){
        assertNotNull(categoriaRepository.findAll());
        System.out.println("@Test -> ListadoCategoriasTest");
    }

}
