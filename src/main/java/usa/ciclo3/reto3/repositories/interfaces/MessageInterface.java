

package usa.ciclo3.reto3.repositories.interfaces;


import org.springframework.data.repository.CrudRepository;
import usa.ciclo3.reto3.models.Message;



public interface MessageInterface extends CrudRepository<Message, Integer> {
    
}


