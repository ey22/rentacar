package Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<CarInformation> getAllCars() {
        return carRepository.findAll();
    }

    public CarInformation getCarById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Car not found with id: " + id));
    }

    public List<CarInformation> getCarsByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

    public List<CarInformation> filterCars(String brand, String transmissionType) {
        if ("All".equalsIgnoreCase(brand) && "All".equalsIgnoreCase(transmissionType)) {
            return carRepository.findAll();
        } else if ("All".equalsIgnoreCase(brand)) {
            return carRepository.findByTransmissionType(transmissionType);
        } else if ("All".equalsIgnoreCase(transmissionType)) {
            return carRepository.findByBrand(brand);
        }else if (brand != null && transmissionType != null) {
            return carRepository.findByBrandAndTransmissionType(brand, transmissionType);
        } else if (brand != null) {
            return carRepository.findByBrand(brand);
        } else if (transmissionType != null) {
            return carRepository.findByTransmissionType(transmissionType);
        } else {
            return carRepository.findAll();
        }
    }



    public CarInformation createCar(CarInformation car) {
        return carRepository.save(car);
    }

    public CarInformation updateCar(Long id, CarInformation updatedCar) {
        CarInformation existingCar = getCarById(id);
        existingCar.setName(updatedCar.getName());
        existingCar.setBrand(updatedCar.getBrand());
        existingCar.setTransmissionType(updatedCar.getTransmissionType());
        existingCar.setFuelType(updatedCar.getFuelType());
        existingCar.setPrice(updatedCar.getPrice());
        existingCar.setImageUrl(updatedCar.getImageUrl());
        return carRepository.save(existingCar);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
