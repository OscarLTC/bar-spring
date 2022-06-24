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
@Entity(name = "Marca")
@Table(name = "marca")
public class Marca implements Serializable {

    private static final long serialVersion = 1L;

    @Id
    @Column(name = "cod_marca")
    private long codigo;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name="cod_categoria", nullable = false)
    private Categoria categoria;

}
