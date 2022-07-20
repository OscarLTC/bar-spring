package blc.idat.apiblc.rest;

import blc.idat.apiblc.models.Cliente;
import blc.idat.apiblc.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteService cliService;

    @GetMapping("/byUser/{codigo}")
    public Optional<Cliente> findByUser(@PathVariable Long codigo){
        return cliService.findByUser(codigo);
    }

    @PutMapping("/update/{id}")
    public Cliente updateCliente(@RequestBody Cliente cli, @PathVariable("id") Long id ){
        return cliService.updateClient(cli,id);
    }

}
