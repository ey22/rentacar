package eylul.rentacar.reservations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
//This class acts as a bridge between the ReservationController and ReservationRepository
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    //Retrieve all reservations from the database, return list
    public List<ReservationInformation> getAllReservations() {
        return reservationRepository.findAll();
    }

    //Retrieve a reservation by its unique ID
    public ReservationInformation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found with ID: " + id));
    }

    //Retrieve a reservation by user's unique ID
    public List<ReservationDetailsDto> getReservationsByUserId(Long userId) {
        List<ReservationInformation> reservations = reservationRepository.findByUserId(userId);
        return reservations.stream().map(reservation -> {
            ReservationDetailsDto dto = new ReservationDetailsDto();
            dto.setReservationId(reservation.getReservationId());
            dto.setCarName(reservation.getCar().getName());
            dto.setCarBrand(reservation.getCar().getBrand());
            dto.setExtraName(reservation.getPlansInformation() != null ? reservation.getPlansInformation().getPlanType() : "None");
            dto.setPickUpDate(new SimpleDateFormat("MM-dd-yyyy").format(reservation.getPickUpDate()));
            dto.setReturnDate(new SimpleDateFormat("MM-dd-yyyy").format(reservation.getReturnDate()));
            dto.setTotalPrice(reservation.getTotalPrice());
            return dto;
        }).collect(Collectors.toList());
    }

    public ReservationInformation createReservation(ReservationInformation reservation) {
        return reservationRepository.save(reservation);
    }

    public ReservationInformation updateReservation(Long id, ReservationInformation updatedReservation) {
        ReservationInformation existingReservation = getReservationById(id);
        existingReservation.setUserId(updatedReservation.getUserId());
        existingReservation.setCarId(updatedReservation.getCarId());
        existingReservation.setProtectionId(updatedReservation.getProtectionId());
        existingReservation.setLocation(updatedReservation.getLocation());
        existingReservation.setPickUpDate(updatedReservation.getPickUpDate());
        existingReservation.setReturnDate(updatedReservation.getReturnDate());
        existingReservation.setTotalPrice(updatedReservation.getTotalPrice());
        return reservationRepository.save(existingReservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
