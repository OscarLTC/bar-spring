package blc.idat.apiblc.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Pedido")
@Table(name = "pedido")
public class Pedido implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @Column(name = "cod_pedido")
    private long cod_pedido;

    @Column(name = "fecha_solicitud")
    private Date fecha_solicitud;

    @Column(name = "fecha_envio")
    private Date fecha_envio;

    @Column(name = "dni_recibidor")
    private String dni_recibidor;

    @Column(name = "precio_total")
    private Double precio_total;

    @ManyToOne
    @JoinColumn(name = "cod_pedido_estado", nullable = false)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name="cod_cliente", nullable = false)
    private Cliente cliente;
}
