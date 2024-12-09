package eylul.rentacar.reservations;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //This marks the class as a REST controller for handling HTTP requests
@RequestMapping("/reservations") //Base URL for all endpoints in this controller
@CrossOrigin(origins = "http://localhost:8080") //Web application runs on one port to request resources
//Handles HTTP Requests and return responses
public class ReservationController {
    //Create object to use its methods
    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    //Fetch all reservations from database and return list of reservations
    @GetMapping
    public List<ReservationInformation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    //Fetch reservation details by id for a specific reservation
    @GetMapping("/{id}")
    public ReservationInformation getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    //Fetch user's all reservations from database and return list of reservations
    @GetMapping("/user/{userId}")
    public List<ReservationDetailsDto> getReservationsByUserId(@PathVariable Long userId) {
        return reservationService.getReservationsByUserId(userId);
    }

    //Add a new reservation to the database
    @PostMapping
    public ReservationInformation createReservation(@RequestBody ReservationInformation reservation) {
        return reservationService.createReservation(reservation);
    }

    //Update reservation details of an existing one
    @PutMapping("/{id}")
    public ReservationInformation updateReservation(@PathVariable Long id, @RequestBody ReservationInformation updatedReservation) {
        return reservationService.updateReservation(id, updatedReservation);
    }

    //Delete an existing reservation with its id
    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}
