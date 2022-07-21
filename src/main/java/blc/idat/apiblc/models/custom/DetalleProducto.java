package blc.idat.apiblc.models.custom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DetalleProducto {
    private Long idproducto;
    private int cantidad;
    private Double subtotal;
}
