package blc.idat.apiblc.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Evento")
@Table(name = "evento")
public class Evento implements Serializable {

    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_evento")
    private Long codigo;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "imagen_principal")
    private String imagen;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "hora")
    private String hora;

    @Column(name = "estado")
    private boolean estado;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cod_evento")
    private List<ImagenSecundaria> imagenes;


}
