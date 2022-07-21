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
@Entity
@IdClass(DetallePedido.class)
@Table(name = "detallepedido")
public class DetallePedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cod_pedido")
    private Long idpedido;

    @Id
    @Column(name = "cod_producto")
    private Long idproducto;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_subtotal")
    private Double subtotal;
}
