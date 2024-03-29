package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Marca;
import blc.idat.apiblc.models.Producto;

import java.util.List;

public interface MarcaService {

    List<Marca> findAll();

    List<Marca> findByCategory(Long id);

    Marca registerMarca(Marca marca);

    Integer changeStatus(Long id);

}
