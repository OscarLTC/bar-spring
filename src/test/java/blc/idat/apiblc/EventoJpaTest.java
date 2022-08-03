package blc.idat.apiblc;

import blc.idat.apiblc.models.Evento;
import blc.idat.apiblc.repository.EventoRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Mantengan esta anotación para trabajar con la bd real
public class EventoJpaTest {

    private static Evento evento;

    @Autowired
    private EventoRepository eventoRepository;

    @BeforeAll
    public static void Inicio(){
        evento = new Evento();
        System.out.println("@BeforeAll -> Inicio()");
    }

    @AfterAll
    public static void Final(){
        evento = null;
        System.out.println("@AfterAll -> Final()");
    }

    // No usen la anotación rollback = false para no afectar los registros de la bd directamente

    @Test
    public void PlantillaTest(){
        System.out.println("@Test -> PlantillaTest");
    }

}
