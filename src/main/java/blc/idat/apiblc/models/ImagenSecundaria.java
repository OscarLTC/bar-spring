package blc.idat.apiblc.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "imagen_secundaria")
public class ImagenSecundaria {

    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_img_secundaria")
    private Long codigo;

    @Column(name ="imagen")
    private String imagen;

    @Column(name = "cod_evento")
    private Long cod_evento;


}
