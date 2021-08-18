package cesde.net.parqueadero.domain.services;

import cesde.net.parqueadero.data.daos.OwnerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OwnerServiceImpl  {

    @Autowired
    private OwnerDao ownerDao;

}
