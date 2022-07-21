package blc.idat.apiblc.models;

import lombok.Data;

import java.sql.Date;
import java.util.Collection;

@Data
public class Venta {
    private int idusuario;
    private int estado;
    private Date fecha_envio;
    private String dni_receptor;
    private Collection<DetalleProducto> detalle;
}
