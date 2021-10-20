/** < - - - - - - - - {  } - - - - - - - - > */

package usa.ciclo3.reto3.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto3.models.Message;
import usa.ciclo3.reto3.repositories.MessageRepo;


@Service
public class MessageService {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    
    @Autowired
    private MessageRepo metodosCrud;
    
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    public List<Message> getAll() {
        return metodosCrud.getAll();
    }
    
    public Optional<Message> getMessage(int messageId) {
        return metodosCrud.getMessage(messageId);
    }
    
    public Message save(Message message) {
        if (message.getIdMessage()== null) {
            return metodosCrud.save(message);
            
        } else {
            Optional<Message> evt = metodosCrud.getMessage(message.getIdMessage());
            
            if (evt.isEmpty()) {
                return metodosCrud.save(message);
                
            } else {
                return message;
                
            }
            
        }
        
    }
    
}


