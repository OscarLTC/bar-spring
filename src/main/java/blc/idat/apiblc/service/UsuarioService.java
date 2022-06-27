package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario registerUser(Usuario usuario);

    List<Usuario> listUsers();


}
