

package usa.ciclo3.reto3.repositories.interfaces;


import org.springframework.data.repository.CrudRepository;
import usa.ciclo3.reto3.models.Reservation;



public interface ReservationInterface extends CrudRepository<Reservation, Integer> {
    
}


