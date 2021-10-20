/** < - - - - - - - - {  } - - - - - - - - > */

package usa.ciclo3.reto3.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto3.models.Machine;
import usa.ciclo3.reto3.repositories.MachineRepo;


@Service
public class MachineService {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    @Autowired
    private MachineRepo metodosCrud;
    
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    public List<Machine> getAll() {
        return metodosCrud.getAll();
    }
    
    public Optional<Machine> getMachine(int machineId) {
        return metodosCrud.getMachine(machineId);
    }
    
    public Machine save(Machine machine) {
        if (machine.getId()== null) {
            return metodosCrud.save(machine);
            
        } else {
            Optional<Machine> evt = metodosCrud.getMachine(machine.getId());
            
            if (evt.isEmpty()) {
                return metodosCrud.save(machine);
                
            } else {
                return machine;
                
            }
            
        }
        
    }
    
}


