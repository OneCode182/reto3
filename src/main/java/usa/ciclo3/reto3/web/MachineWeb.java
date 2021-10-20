/** < - - - - - - - - {  } - - - - - - - - > */

package usa.ciclo3.reto3.web;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import usa.ciclo3.reto3.models.Machine;
import usa.ciclo3.reto3.services.MachineService;



@RestController
@RequestMapping("/api/Machine")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MachineWeb {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    
    @Autowired
    private MachineService servicios;
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    @GetMapping("/all")
    public List<Machine> getMachines() {
        return servicios.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Machine> getMachine(@PathVariable("id") int machineId) {
        return servicios.getMachine(machineId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine save(@RequestBody Machine machine) {
        return servicios.save(machine);
    }
    
}


