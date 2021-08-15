package cesde.net.parqueadero.api.controller;

import cesde.net.parqueadero.data.model.Car;
import cesde.net.parqueadero.domain.services.access.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CarController.CARS)
public class CarController {

    public static final String SAVE_CARS = "/car-save";
    public static final String FIND_CAR = "/find-car/{id}";
    public static final String ALL_CARS = "/find/all-cars";
    public static final String CARS = "/API/car";

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(ALL_CARS)
    public List<Car> getAll() {
        return carService.getAll();
    }

    @GetMapping(FIND_CAR)
    public Car find(@PathVariable String id) {
        return carService.get(id);
    }

    @PostMapping(SAVE_CARS)
    public ResponseEntity<Car> save (@RequestBody Car car) {
        Car obj = carService.save(car);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }


}
