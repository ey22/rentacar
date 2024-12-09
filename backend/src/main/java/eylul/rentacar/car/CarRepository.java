package eylul.rentacar.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//Repository interface for managing CarInformation entities
//Provide some methods for interacting database
//Extend Jpa repository to inherit default database methods(save, delete,etc.)
@Repository
public interface CarRepository extends JpaRepository<CarInformation, Long> {
        //Find all cars by their brand, transmission type and both
        List<CarInformation> findByBrand(String brand);
        List<CarInformation> findByTransmissionType(String transmissionType);
        List<CarInformation> findByBrandAndTransmissionType(String brand, String transmissionType);
    }



