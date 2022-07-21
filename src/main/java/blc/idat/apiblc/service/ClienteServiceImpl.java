package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Cliente;
import blc.idat.apiblc.models.Usuario;
import blc.idat.apiblc.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository cliRepo;

    @Override
    public Cliente registerClientOnlyUser(Usuario user) {
        Cliente cl =  new Cliente();
        cl.setUsuario(user);
        return cliRepo.save(cl);
    }

    @Override
    public Optional<Cliente> findByUser(Long codigo){
        return cliRepo.findByClient(codigo);
    }

    @Override
    public Cliente updateClient(Cliente cl, Long id) {
        cl.setCodigo(id);
        return cliRepo.save(cl);
    }

    @Override
    public Cliente findById(int id) {
        return cliRepo.findById(id);
    }


}
