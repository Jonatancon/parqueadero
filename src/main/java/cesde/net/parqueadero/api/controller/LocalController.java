package cesde.net.parqueadero.api.controller;

import cesde.net.parqueadero.api.dtos.LocalDto;
import cesde.net.parqueadero.api.dtos.Message;
import cesde.net.parqueadero.data.model.Local;
import cesde.net.parqueadero.domain.services.LocalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(LocalController.LOCAL)
@CrossOrigin
public class LocalController {

    public final static String LOCAL = "/api/local";
    public final static String FIND = "/find/{id}";
    public final static String UPDATE = "/update";

    @Autowired
    private LocalServiceImpl localService;

    @GetMapping(FIND)
    public ResponseEntity<Local> getLocal (@PathVariable Long id) {
        Local local = localService.getLocal(id);

        return new ResponseEntity<>(local, HttpStatus.OK);
    }

    @PostMapping(UPDATE)
    public ResponseEntity<?> updateLocal (@RequestBody LocalDto localDto) {

        if (localDto.getOccupiedPlaces() == null || localDto.getOccupiedPlaces() < 0)
            return new ResponseEntity<>(new Message("Error el los lugares ocupados"), HttpStatus.BAD_REQUEST);
        if (localDto.getReservedPlaces() == null || localDto.getReservedPlaces() < 0)
            return new ResponseEntity<>(new Message("Error el los lugares reservados"), HttpStatus.BAD_REQUEST);
        if (localDto.getAvailableSpace() == null || localDto.getAvailableSpace() < 0)
            return new ResponseEntity<>(new Message("Error el los lugares disponibles"), HttpStatus.BAD_REQUEST);
        if (localDto.getTotalPlaces() == null || localDto.getTotalPlaces() < 0)
            return new ResponseEntity<>(new Message("Error en el total de lugares"), HttpStatus.BAD_REQUEST);

        Local local = new Local(localDto.getId(),localDto.getAvailableSpace(), localDto.getReservedPlaces(),
                localDto.getOccupiedPlaces(), localDto.getTotalPlaces());
        localService.updateLocal(local);

        return new ResponseEntity<>(new Message("Local Actualizado"), HttpStatus.OK);
    }

}
