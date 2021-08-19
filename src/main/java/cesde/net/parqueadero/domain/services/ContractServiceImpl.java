package cesde.net.parqueadero.domain.services;

import cesde.net.parqueadero.data.daos.ContractDao;
import cesde.net.parqueadero.data.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContractServiceImpl {

    @Autowired
    private ContractDao contractDao;

    public List<Contract> getAll () {
        return contractDao.findAll();
    }
}
