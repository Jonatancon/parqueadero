package cesde.net.parqueadero.api.controller;

import cesde.net.parqueadero.api.dtos.Message;
import cesde.net.parqueadero.data.model.Cell;
import cesde.net.parqueadero.domain.services.CellServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CellController.CELL)
@CrossOrigin
public class CellController {

    public final static String CELL = "/api/cell";
    public final static String ALL = "/cell-all";
    public final static String ACTIVES = "/cell-active";
    public final static String UPDATE = "/cell-update";

    @Autowired
    private CellServiceImpl cellService;

    @GetMapping(ALL)
    public ResponseEntity<List<Cell>> getAll () {
        List<Cell> list = cellService.getAll().get();

        if (list.size() == 0) {
            return new ResponseEntity(new Message("No quedan cupos en el parqueadero"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(ACTIVES)
    public ResponseEntity<List<Cell>> getActives () {

        try{
            List<Cell> list = cellService.activeCell().get();

            if (list.size() == 0) {
                return new ResponseEntity(new Message("No hay espacios a reservar"), HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity(new Message("No hay espacios agregados"), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(UPDATE)
    public ResponseEntity<?> update (@RequestBody Cell cell) {
        cellService.update(cell);

        return new ResponseEntity<>(new Message("Celda actualizada"), HttpStatus.OK);
    }

}
