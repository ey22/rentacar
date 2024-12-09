package eylul.rentacar.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController //This marks the class as a REST controller for handling HTTP requests
@RequestMapping("/cars") //Base URL for all endpoints in this controller
@CrossOrigin(origins = "http://localhost:8080") //Web application runs on one port to request resources
//Handles HTTP Requests and return responses
public class CarController {
    @Autowired
    private CarService carService;

    //Fetch all cars from database and return list of cars
    @GetMapping("")
    public List<CarInformation> getAllCars() {
        return carService.getAllCars();
    }

    //Fetch car details by id for a specific car
    @GetMapping("/{id}")
    public ResponseEntity<CarInformation> getCarById(@PathVariable Long id) {
        CarInformation car = carService.getCarById(id);
        return ResponseEntity.ok(car);
    }

    //Check if there is a car registered in the table. If not, throw exception
    @GetMapping("/first")
    public ResponseEntity<CarInformation> getFirstCar() {
        CarInformation firstCar = carService.getAllCars().stream().findFirst().orElseThrow(() -> new NoSuchElementException("No cars found!"));
        return ResponseEntity.ok(firstCar);
    }

    //Filter cars based on brand and transmission type
    //Use query parameters to specify the filtering criteria
    @GetMapping("/filter")
    public ResponseEntity<List<CarInformation>> filterCars( @RequestParam(required = false) String brand,
                                                                   @RequestParam(required = false) String transmissionType) {
        List<CarInformation> cars = carService.filterCars(brand,transmissionType);
        return ResponseEntity.ok(cars);
    }

    //Add a new car to the database
    @PostMapping("")
    public ResponseEntity<CarInformation> createCar(@RequestBody CarInformation car) {
        CarInformation createdCar = carService.createCar(car);
        return ResponseEntity.ok(createdCar);
    }

    //Update car details of an existing one
    @PutMapping("/{id}")
    public ResponseEntity<CarInformation> updateCar(@PathVariable Long id, @RequestBody CarInformation updatedCar) {
        CarInformation car = carService.updateCar(id, updatedCar);
        return ResponseEntity.ok(car);
    }

    //Delete an existing car with its id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
