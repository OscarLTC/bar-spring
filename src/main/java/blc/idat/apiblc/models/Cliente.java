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
@Entity(name = "Cliente")
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cliente")
    private long codigo;

    @Column(name = "nombres")
    private String nombre;

    @Column(name = "apellido_paterno")
    private String apPaterno;

    @Column(name = "apellido_materno")
    private String apMaterno;

    @Column(name = "dni")
    private String dni;

    @Column(name = "telefono")
    private String telefono;

    @OneToOne
    @JoinColumn(name = "cod_usuario", nullable = false)
    private Usuario usuario;

}
