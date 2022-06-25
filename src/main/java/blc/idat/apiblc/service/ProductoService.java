package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> findAll();

    List<Producto> findByCliente(int id);

    Optional<Producto> findById(Long id);


}
