package blc.idat.apiblc.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Producto")
@Table(name = "PRODUCTO")
public class Producto implements Serializable {

    private static final long serialVersion = 1L;

    @Id
    @Column(name = "COD_PRODUCTO")
    private long codigo;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "PRECIO")
    private double precio;

    @Column(name = "IMAGEN")
    private String imagen;

    @Column(name = "ESTADO")
    private boolean estado;



}
