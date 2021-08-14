package cesde.net.parqueadero.domain.services.impl;

import cesde.net.parqueadero.commons.GenericServiceImpl;
import cesde.net.parqueadero.data.daos.ContractDao;
import cesde.net.parqueadero.data.model.Contract;
import cesde.net.parqueadero.domain.services.access.ContractService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl extends GenericServiceImpl<Contract,Long> implements ContractService {

    private final ContractDao contractDao;

    public ContractServiceImpl(ContractDao contractDao) {
        this.contractDao = contractDao;
    }


    @Override
    public JpaRepository<Contract, Long> getDao() {
        return contractDao;
    }
}
