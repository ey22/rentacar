package eylul.rentacar.reservations;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationInformation,Long> {

    List<ReservationInformation> findByUserId(Long userId);
}
