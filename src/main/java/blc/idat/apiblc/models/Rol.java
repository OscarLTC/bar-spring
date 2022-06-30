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
@Entity(name = "Rol")
@Table(name = "rol")
public class Rol implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @Column(name = "cod_rol")
    private long codigo;

    @Column(name = "nombre")
    private String nombre;
}
