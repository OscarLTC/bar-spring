package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Precio;
import blc.idat.apiblc.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> findAll();

    List<Producto> findByCliente(int id);

    Optional<Producto> findById(Long id);

    Producto registerProduct(Producto pro);
    Producto updateProduct(Producto pro, Long id);

    List<Producto> findByName(String name);

    List<Producto> findByPrecio(Precio precio);
}
