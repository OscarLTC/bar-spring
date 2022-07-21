package blc.idat.apiblc.service;

import blc.idat.apiblc.models.custom.Login;
import blc.idat.apiblc.models.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario registerUser(Usuario usuario);

    List<Usuario> listUsers();

    Usuario login(String email, String pass);
    Usuario changePassword(Login dataUser);
    Usuario checkExistenceEmail(String email);



}
