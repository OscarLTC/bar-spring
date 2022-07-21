package blc.idat.apiblc.repository;

import blc.idat.apiblc.models.DetallePedido;
import blc.idat.apiblc.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {

}
