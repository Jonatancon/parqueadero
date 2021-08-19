package cesde.net.parqueadero.api.controller;

import cesde.net.parqueadero.data.model.Contract;
import cesde.net.parqueadero.domain.services.ContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ContractController.CONTRACT)
@CrossOrigin
public class ContractController {

    public final static String CONTRACT = "/api/contract";
    public final static String LIST = "/list";

    @Autowired
    private ContractServiceImpl contractService;

    @GetMapping(LIST)
    public ResponseEntity<Contract> list () {
        List<Contract> list = contractService.getAll();

        return new ResponseEntity(list, HttpStatus.OK);
    }
}
