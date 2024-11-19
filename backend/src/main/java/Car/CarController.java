package Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/cars")
@CrossOrigin(origins = "http://localhost:8080")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("")
    public List<CarInformation> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarInformation> getCarById(@PathVariable Long id) {
        CarInformation car = carService.getCarById(id);
        return ResponseEntity.ok(car);
    }

    @GetMapping("/first")
    public ResponseEntity<CarInformation> getFirstCar() {
        CarInformation firstCar = carService.getAllCars().stream().findFirst().orElseThrow(() -> new NoSuchElementException("No cars found!"));
        return ResponseEntity.ok(firstCar);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<CarInformation>> filterCars( @RequestParam(required = false) String brand,
                                                                   @RequestParam(required = false) String transmissionType) {
        List<CarInformation> cars = carService.filterCars(brand,transmissionType);
        return ResponseEntity.ok(cars);
    }



    @PostMapping("")
    public ResponseEntity<CarInformation> createCar(@RequestBody CarInformation car) {
        CarInformation createdCar = carService.createCar(car);
        return ResponseEntity.ok(createdCar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarInformation> updateCar(@PathVariable Long id, @RequestBody CarInformation updatedCar) {
        CarInformation car = carService.updateCar(id, updatedCar);
        return ResponseEntity.ok(car);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
