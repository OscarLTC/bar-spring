package blc.idat.apiblc.models.custom;


import blc.idat.apiblc.models.Estado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoUpdateCustom03 {

    private Long codigo;
    private String telefono;
    private String dni;
    private Estado estado;
}
