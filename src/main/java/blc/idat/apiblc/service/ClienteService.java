package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Cliente;
import blc.idat.apiblc.models.Usuario;

public interface ClienteService {

    Cliente registerClientOnlyUser(Usuario user);

}
