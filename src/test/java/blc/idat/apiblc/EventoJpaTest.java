package blc.idat.apiblc;

import blc.idat.apiblc.models.Evento;
import blc.idat.apiblc.repository.EventoRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


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
    public void ListadoEventosTest(){
        assertNotNull(eventoRepository.findAll());

        System.out.println("@Test -> ListadoEventosTest");
    }

    @Test
    public void BuscarEventoTest(){
        assertNotNull(eventoRepository.findEventoById(2L));
        System.out.println("@Test -> BuscarEventoTest");
    }

    @Test
    public void BuscarPorRangoFechaTest() throws ParseException{
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
        Date fechaInicio = formato.parse("20220612");
        Date fechaFin    = formato.parse("20220812");
        java.sql.Date fecha1 = new java.sql.Date(fechaInicio.getTime());
        java.sql.Date fecha2 = new java.sql.Date(fechaFin.getTime());

        List<Evento> e = eventoRepository.finEventoByDate(fecha1,fecha2);
        assertNotNull(e);
        System.out.println("@Test -> BuscarPorRangoFechaTest()");
    }

    @Test
    public void BuscarPorFechaTest() throws ParseException{
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
        Date fecha = formato.parse("20220530"); // --- debe coincidir con la base de datos
        java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());

        Evento e = eventoRepository.findByFecha(fechaSQL);
        assertNotNull(e);
        System.out.println("@Test -> BuscarPorFechaTest()");
    }
}
