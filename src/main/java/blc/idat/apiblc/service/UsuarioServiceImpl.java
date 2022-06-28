package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Cliente;
import blc.idat.apiblc.models.Usuario;
import blc.idat.apiblc.repository.ClienteRepository;
import blc.idat.apiblc.repository.UsuarioRepository;
import blc.idat.apiblc.security.IEncrypt;
import blc.idat.apiblc.security.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuRepo;

    @Autowired
    private ClienteRepository cliRepo;

    @Override
    public Usuario registerUser(Usuario usuario) {
        IEncrypt encryptService = new Encrypt();
        usuario.setContrasena(encryptService.encryptPassword(usuario.getContrasena()));
        try{
            Usuario newUsuario = usuRepo.save(usuario);

            Usuario usuarioInBd = usuRepo.searchByEmail(newUsuario.getCorreo());

            if (usuarioInBd == null) throw new Exception();

            Cliente clientOfNewUser = new Cliente();

            clientOfNewUser.setUsuario(usuarioInBd);
            cliRepo.save(clientOfNewUser);

            return newUsuario;

        } catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Usuario> listUsers(){
        return usuRepo.findAll();
    }

    @Override
    public Usuario login(String email, String pass) {
        Usuario usuario = usuRepo.searchByEmail(email);
        IEncrypt encryptService = new Encrypt();
    try {
        if (encryptService.verifyPassword(pass, usuario.getContrasena())) {
            return usuario;
        } else {
            return null;
        }
    }catch (Exception e){
        return null;
        }
    }


}
