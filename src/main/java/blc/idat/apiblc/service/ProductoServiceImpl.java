package blc.idat.apiblc.service;

import blc.idat.apiblc.models.custom.Precio;
import blc.idat.apiblc.models.Producto;
import blc.idat.apiblc.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository proRepo;

    @Override
    public List<Producto> findAll() {
        return proRepo.findAll();
    }

    @Override
    public List<Producto> findByCliente(int id) {

        List<Producto> finalList = new ArrayList<Producto>();

        List<Producto> allProducts = proRepo.findAll();
        List<Producto> clienteProducts = proRepo.findByCliente(id);

        finalList = Stream.concat(clienteProducts.stream(), allProducts.stream()).collect(Collectors.toList());

        finalList = (ArrayList<Producto>) finalList.stream().distinct().collect(Collectors.toList());

        return finalList;
    }

    @Override
    public Optional<Producto> findById(Long id){
        return proRepo.findById(id);
    }

    @Override
    public Producto registerProduct(Producto pro){
        return proRepo.save(pro);
    }

    @Override
    public Producto updateProduct(Producto pro, Long id){
        pro.setCodigo(id);
        return proRepo.save(pro);
    }

    @Override
    public List<Producto> findByName(String name) {
        return proRepo.findByName(name);
    }

    @Override
    public List<Producto> findByPrecio(Precio precio) {
        return proRepo.findByPrecio(precio.getMin(), precio.getMax());
    }

    @Override
    public List<Producto> findByCategory(Long id) {
        return proRepo.findByCategory(id);
    }

    @Override
    public List<Producto> findByBrand(Long id){
        return proRepo.findByBrand(id);
    }

    @Override
    public Integer updateStatus(Long id) {
        return proRepo.updateStatus(id);
    }

    @Override
    public List<Producto> findProductsByState(Boolean estado) {
        return proRepo.findProductsByState(estado);
    }

}
