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
public class PedidoFecha {

    private Date fecha_inicio;
    private Date fecha_final;

}
