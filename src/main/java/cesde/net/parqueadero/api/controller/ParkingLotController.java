package cesde.net.parqueadero.api.controller;

import cesde.net.parqueadero.api.dtos.Message;
import cesde.net.parqueadero.api.dtos.ParkingLotDto;
import cesde.net.parqueadero.data.model.ParkingLot;
import cesde.net.parqueadero.domain.services.ParkingLotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(ParkingLotController.PARKING)
@CrossOrigin
public class ParkingLotController {

    public final static String PARKING = "/api/parking";
    public final static String SAVE = "/save";
    public final static String CAR_ACTIVE = "/car-active/{id}";
    public final static String ALL_ACTIVES = "/alls-active";
    public final static String UPDATE = "/update";

    @Autowired
    private ParkingLotServiceImpl parkingLotService;

    @GetMapping(CAR_ACTIVE)
    public ResponseEntity<ParkingLot> getCarActive (@PathVariable Long id) {
        if (!parkingLotService.existById(id))
            return new ResponseEntity(new Message("El carro no ha Ingresado"), HttpStatus.NOT_FOUND);

        ParkingLot parkingLot = parkingLotService.findParking(id);
        return new ResponseEntity<>(parkingLot, HttpStatus.OK);
    }

    @GetMapping(ALL_ACTIVES)
    public ResponseEntity<List<ParkingLot>> getAllActives () {
        try{
            List<ParkingLot> list = parkingLotService.findAllActives().get();

            if (list.size() == 0) {
                return new ResponseEntity(new Message("No hay Vehiculos en el Parqueadero"), HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity(new Message("No hay vehiculos en el parqueadero"), HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(SAVE)
    public ResponseEntity<?> create (@RequestBody ParkingLotDto parkingLotDto) throws ParseException {

        try{
            if (parkingLotService.existCarActive(parkingLotDto.getCar()))
                return new ResponseEntity<>(new Message("El vehiculo ya se encuentra en el parqueadero"),
                        HttpStatus.BAD_REQUEST);
        }catch (Exception e) {

        }

        parkingLotDto.setStartDate();

        ParkingLot parkingLot = new ParkingLot(parkingLotDto.getCar(), parkingLotDto.getCell(),
                parkingLotDto.getStartDate(), parkingLotDto.getFinalDate(),parkingLotDto.getActive());

        parkingLotService.save(parkingLot);

        return new ResponseEntity<>(new Message("Vehiculo guardado en el parqueadero"), HttpStatus.OK);
    }

    @PostMapping(UPDATE)
    public ResponseEntity<?> update (@RequestBody ParkingLotDto parkingLotDto) throws ParseException {

        parkingLotDto.setFinaltDate();

        ParkingLot parkingLot = new ParkingLot(parkingLotDto.getId() ,parkingLotDto.getCar(),
                parkingLotDto.getCell(), parkingLotDto.getStartDate(), parkingLotDto.getFinalDate(),false);

        parkingLotService.save(parkingLot);

        return new ResponseEntity<>(parkingLotDto.diff(), HttpStatus.OK);
    }
}
