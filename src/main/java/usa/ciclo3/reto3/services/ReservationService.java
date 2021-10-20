/** < - - - - - - - - {  } - - - - - - - - > */

package usa.ciclo3.reto3.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto3.models.Reservation;
import usa.ciclo3.reto3.repositories.ReservationRepo;


@Service
public class ReservationService {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    
    @Autowired
    private ReservationRepo metodosCrud;
    
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    public List<Reservation> getAll() {
        return metodosCrud.getAll();
    }
    
    public Optional<Reservation> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }
    
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation()== null) {
            return metodosCrud.save(reservation);
            
        } else {
            Optional<Reservation> evt = metodosCrud.getReservation(reservation.getIdReservation());
            
            if (evt.isEmpty()) {
                return metodosCrud.save(reservation);
                
            } else {
                return reservation;
                
            }
            
        }
        
    }
    
}


