package cesde.net.parqueadero.api.controller;

import cesde.net.parqueadero.api.dtos.Message;
import cesde.net.parqueadero.api.dtos.OwnerDto;
import cesde.net.parqueadero.data.model.Owner;
import cesde.net.parqueadero.domain.services.OwnerServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(OwnerController.OWNER)
@CrossOrigin
public class OwnerController {

    public final static String OWNER = "/api/owner";
    public final static String SAVE_OWNER = "/save";
    public final static String GET_OWNER = "/get-owner/{dni}";

    @Autowired
    private OwnerServiceImpl ownerService;

    @PostMapping(SAVE_OWNER)
    public ResponseEntity<?> create(@RequestBody OwnerDto ownerDto) {

        if (StringUtils.isBlank(ownerDto.getDni()))
            return new ResponseEntity(new Message("Error en el DNI"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(ownerDto.getName()))
            return new ResponseEntity(new Message("Error en el Nombre"), HttpStatus.BAD_REQUEST);
        if  (ownerService.existDni(ownerDto.getDni()))
            return new ResponseEntity(new Message("Este Propietario ya existe"), HttpStatus.BAD_REQUEST);

        Owner owner = new Owner(ownerDto.getDni(), ownerDto.getName());
        ownerService.saveOwner(owner);

        return new ResponseEntity(new Message("Propietario agregado"), HttpStatus.CREATED);
    }

    @GetMapping(GET_OWNER)
    public ResponseEntity<Owner> getOwner (@PathVariable String dni) {
        if (!ownerService.existDni(dni))
            return new ResponseEntity(new Message("No existe el propietario"), HttpStatus.NOT_FOUND);

        Owner owner = ownerService.get(dni);

        return new ResponseEntity<Owner>(owner, HttpStatus.OK);
    }

}
