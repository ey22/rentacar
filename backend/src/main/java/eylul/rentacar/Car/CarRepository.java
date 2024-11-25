package eylul.rentacar.Car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarInformation, Long> {
        List<CarInformation> findByBrand(String brand);
        List<CarInformation> findByTransmissionType(String transmissionType);
        List<CarInformation> findByBrandAndTransmissionType(String brand, String transmissionType);
    }



