package cesde.net.parqueadero.api.controller;

import cesde.net.parqueadero.api.dtos.CarDto;
import cesde.net.parqueadero.api.dtos.Message;
import cesde.net.parqueadero.data.model.Car;
import cesde.net.parqueadero.domain.services.CarServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CarController.CARS)
@CrossOrigin
public class CarController {

    public static final String SAVE_CARS = "/car-save";
    public static final String FIND_CAR = "/find-car/{id}";
    public static final String CARS = "/api/car";

    @Autowired
    private CarServiceImpl carService;

    @PostMapping(SAVE_CARS)
    public ResponseEntity<?> create (@RequestBody CarDto carDto) {

        if (StringUtils.isBlank(carDto.getDniCar()))
            return new ResponseEntity<>(new Message("Obligatorio matricula"), HttpStatus.BAD_REQUEST);
        if (carService.existCar(carDto.getDniCar()))
            return new ResponseEntity<>(new Message("El carro ya existe"), HttpStatus.BAD_REQUEST);

        Car car = new Car(carDto.getDniCar(), carDto.getOwner(), carDto.getContract());
        carService.save(car);

        return new ResponseEntity<>(new Message("Vehiculo guardado"), HttpStatus.CREATED);
    }

    @GetMapping(FIND_CAR)
    public ResponseEntity<Car> getCar (@PathVariable String id) {
        if (!carService.existCar(id))
            return new ResponseEntity(new Message("El vehiculo no existe"), HttpStatus.NOT_FOUND);

        Car car = carService.get(id);

        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }

}
