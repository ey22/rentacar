package eylul.rentacar.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
//This class acts as a bridge between the CarController and CarRepository
@Service // Marks this class as a service layer component
public class CarService {
    @Autowired
    private CarRepository carRepository;
    //Retrieve all cars from the database, return list
    public List<CarInformation> getAllCars() {
        return carRepository.findAll();
    }

    //Retrieve a car by its unique ID
    public CarInformation getCarById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Car not found with id: " + id));
    }
    //Filter cars based on brand
    public List<CarInformation> getCarsByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }
    //Filter cars based on brand and transmission type
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
    //Add new car to the database
    public CarInformation createCar(CarInformation car) {
        return carRepository.save(car);
    }

    // Update an existing car in the database
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

    //Delete a car from the database
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
