package blc.idat.apiblc.rest;


import blc.idat.apiblc.models.custom.Login;
import blc.idat.apiblc.models.Usuario;
import blc.idat.apiblc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuService;

    @PostMapping()
    public Usuario registerUser(@RequestBody Usuario usuario){

        Usuario newUsuario = usuService.registerUser(usuario);
        return newUsuario;
    }

    @GetMapping("/all")
    public List<Usuario> listUsers(){
        return usuService.listUsers();
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody Login login){
        return usuService.login(login.getEmail(), login.getPass());
    }

    @PutMapping()
    public Usuario changePassword(@RequestBody Login login){
        return usuService.changePassword(login);
    }

    @GetMapping("/email/{email}")
    public Usuario checkExistenceEmail(@PathVariable("email") String email){
        return usuService.checkExistenceEmail(email);
    }

}
