package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Marca;
import blc.idat.apiblc.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService{


    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }

    @Override
    public List<Marca> findByCategory(Long id) {
        return marcaRepository.findByCategory(id);
    }

    @Override
    public Marca registerMarca(Marca marca){
        return marcaRepository.save(marca);
    }

}
