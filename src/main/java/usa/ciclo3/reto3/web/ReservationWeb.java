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
import usa.ciclo3.reto3.models.Reservation;
import usa.ciclo3.reto3.services.ReservationService;



@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationWeb {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    
    @Autowired
    private ReservationService servicios;
    
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    @GetMapping("/all")
    public List<Reservation> getReservations() {
        return servicios.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int reservationId) {
        return servicios.getReservation(reservationId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return servicios.save(reservation);
    }
    
}


