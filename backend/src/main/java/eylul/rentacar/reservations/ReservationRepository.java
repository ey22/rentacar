package eylul.rentacar.reservations;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//Provide some methods for interacting database
//Extend Jpa repository to inherit default database methods(save, delete,etc.)

@Repository
public interface ReservationRepository extends JpaRepository<ReservationInformation,Long> {
    //Find all reservations by their id
    List<ReservationInformation> findByUserId(Long userId);
}
