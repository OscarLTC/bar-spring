package blc.idat.apiblc;

import blc.idat.apiblc.models.ImagenSecundaria;
import blc.idat.apiblc.repository.ImagenSecundariaRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Mantengan esta anotación para trabajar con la bd real
public class ImagenSecundariaJpaTest {

    private static ImagenSecundaria imagenSecundaria;

    @Autowired
    private ImagenSecundariaRepository imagenSecundariaRepository;

    @BeforeAll
    public static void Inicio(){
        imagenSecundaria = new ImagenSecundaria();
        System.out.println("@BeforeAll -> Inicio()");
    }

    @AfterAll
    public static void Final(){
        imagenSecundaria = null;
        System.out.println("@AfterAll -> Final()");
    }

    @Test
    public void RegistrarImagenSecundariaTest() {

        imagenSecundaria = new ImagenSecundaria(null, "https://i.postimg.cc/ncMDg1mn/Evento-04.jpg", 23L);

        ImagenSecundaria imagen = imagenSecundariaRepository.save(imagenSecundaria);

        assertNotNull(imagen);

        System.out.println("@Test -> RegistrarImagenSecundariaTest()");
    }

}
