package blc.idat.apiblc.service;

import blc.idat.apiblc.models.Cliente;
import blc.idat.apiblc.models.custom.Login;
import blc.idat.apiblc.models.Usuario;
import blc.idat.apiblc.repository.ClienteRepository;
import blc.idat.apiblc.repository.UsuarioRepository;
import blc.idat.apiblc.security.IEncrypt;
import blc.idat.apiblc.security.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuRepo;

    @Autowired
    private ClienteRepository cliRepo;

    private final IEncrypt encryptService = new Encrypt();

    @Override
    public Usuario registerUser(Usuario usuario) {
        usuario.setContrasena(encryptService.encryptPassword(usuario.getContrasena()));
        try{
            Usuario usuarioInBd = usuRepo.searchByEmail(usuario.getCorreo());

            if (usuarioInBd != null) throw new Exception();

            usuRepo.save(usuario);

            return usuario;

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



    @Override
    public Usuario changePassword(Login dataUser) {
        Usuario usuario = usuRepo.searchByEmail(dataUser.getEmail());

        usuario.setContrasena(encryptService.encryptPassword(dataUser.getPass()));

        usuRepo.save(usuario);
        return usuario;

    }

    @Override
    public Usuario checkExistenceEmail(String email) {
        return usuRepo.searchByEmail(email);
    }



}
