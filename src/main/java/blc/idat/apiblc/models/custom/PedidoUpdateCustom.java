package blc.idat.apiblc.models.custom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoUpdateCustom {
    private Long cod_pedido;
    private String dni;
    private Date fecha;
}
