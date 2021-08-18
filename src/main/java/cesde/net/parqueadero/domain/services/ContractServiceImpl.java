package cesde.net.parqueadero.domain.services;

import cesde.net.parqueadero.data.daos.ContractDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContractServiceImpl {

    @Autowired
    private ContractDao contractDao;
}
