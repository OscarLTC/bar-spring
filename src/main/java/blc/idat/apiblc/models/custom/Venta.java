package blc.idat.apiblc.models.custom;

import lombok.Data;

import java.sql.Date;
import java.util.Collection;

@Data
public class Venta {
    private int idcliente;
    private int estado;
    private Date fecha_envio;
    private String dni_receptor;
    private Collection<DetalleProducto> detalle;
}
