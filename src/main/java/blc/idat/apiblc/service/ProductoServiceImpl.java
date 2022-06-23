package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Producto;
import blc.idat.apiblc.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository proRepo;

    @Override
    public List<Producto> findAll() {
        return proRepo.findAll();
    }
}
