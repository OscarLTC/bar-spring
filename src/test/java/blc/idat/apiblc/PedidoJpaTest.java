package blc.idat.apiblc;

import blc.idat.apiblc.models.Estado;
import blc.idat.apiblc.models.Pedido;
import blc.idat.apiblc.models.custom.PedidoUpdateCustom02;
import blc.idat.apiblc.repository.PedidoRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class PedidoJpaTest {

    private static Pedido pedido;

    @Autowired
    private PedidoRepository pedidoRepository;

    @BeforeAll
    public static void Inicio(){
        pedido = new Pedido();
        System.out.println("@BeforeAll -> Inicio()");
    }

    @AfterAll
    public static void Final(){
        pedido = null;
        System.out.println("@AfterAll -> Final()");
    }

    // No usen la anotación rollback = false para no afectar los registros de la bd directamente

    @Test
    public void PedidoPorClienteTest(){
        List<Pedido> p = pedidoRepository.findByCliente(3);
        assertNotNull(p);
        System.out.println("@Test -> PedidoPorClienteTest()");
    }

    @Test
    public void PedidoPorIdTest(){
        List<Pedido> p = pedidoRepository.findPedidosById(4);
        assertNotNull(p);
        System.out.println("@Test -> PedidoPorIdTest()");
    }

    @Test
    public void PedidoPorEstadoTest(){
        List<Pedido> p = pedidoRepository.findPedidosByEstado(2);
        assertNotNull(p);
        System.out.println("@Test -> PedidoPorEstadoTest()");
    }
    
    @Test
    public void ActualizarPedidoTest()throws ParseException{
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
        Date fecha = formato.parse("20220912");  //  <------------para la fecha de prueba
        java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
        
        Estado e = new Estado();
        e.setCodigo(2L);
        e.setNombre("Postergado");
        
        pedido.setCod_pedido(3L);
        pedido.setDni_recibidor("76566655");
        pedido.setEstado(e);
        pedido.setFecha_envio(fechaSQL);
        Pedido p = pedidoRepository.save(pedido);
        assertNotNull(p);
        System.out.println("@Test -> ActualizarPedidoTest()");
    }
    
    @Test
    public void ListarPedidosTest(){
        List<Pedido> p = pedidoRepository.findAll();
        assertNotNull(p);
        System.out.println("@Test -> ListarPedidosTest()");
    }

}
