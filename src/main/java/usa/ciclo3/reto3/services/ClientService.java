/** < - - - - - - - - {  } - - - - - - - - > */

package usa.ciclo3.reto3.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto3.models.Client;
import usa.ciclo3.reto3.repositories.ClientRepo;


@Service
public class ClientService {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    
    @Autowired
    private ClientRepo metodosCrud;
    
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    public List<Client> getAll() {
        return metodosCrud.getAll();
    }
    
    public Optional<Client> getClient(int clientId) {
        return metodosCrud.getClient(clientId);
    }
    
    public Client save(Client client) {
        if (client.getIdClient()== null) {
            return metodosCrud.save(client);
            
        } else {
            Optional<Client> evt = metodosCrud.getClient(client.getIdClient());
            
            if (evt.isEmpty()) {
                return metodosCrud.save(client);
                
            } else {
                return client;
                
            }
            
        }
        
    }
    
}


