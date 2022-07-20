package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Cliente;
import blc.idat.apiblc.models.Usuario;

import java.util.Optional;

public interface ClienteService {

    Cliente registerClientOnlyUser(Usuario user);

    Optional<Cliente> findByUser(Long codigo);

    Cliente updateClient(Cliente cl, Long id);

}
