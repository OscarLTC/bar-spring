package blc.idat.apiblc.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Producto")
@Table(name = "producto")
public class Producto implements Serializable {

    private static final long serialVersion = 1L;

    @Id
    @Column(name = "cod_producto")
    private long codigo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private double precio;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "estado")
    private boolean estado;

    @ManyToOne
    @JoinColumn(name="cod_categoria", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name="cod_marca", nullable = false)
    private Marca marca;


}
