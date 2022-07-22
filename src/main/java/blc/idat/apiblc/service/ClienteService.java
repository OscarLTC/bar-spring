package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Cliente;
import blc.idat.apiblc.models.Usuario;

import java.util.Optional;

public interface ClienteService {

    Cliente registerClientOnlyUser(Usuario user);

    Cliente findByUser(Long codigo);

    Cliente createClient(Cliente cl);

    Cliente findById(int id);

}
