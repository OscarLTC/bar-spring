package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Estado;
import blc.idat.apiblc.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstadoServiceImpl implements EstadoService{

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public List<Estado> findAll(){
        return estadoRepository.findAll();
    }
}
