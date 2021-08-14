package cesde.net.parqueadero.domain.services.impl;

import cesde.net.parqueadero.commons.GenericServiceImpl;
import cesde.net.parqueadero.data.daos.OwnerDao;
import cesde.net.parqueadero.data.model.Owner;
import cesde.net.parqueadero.domain.services.access.OwnerService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl extends GenericServiceImpl<Owner,String> implements OwnerService {

    private final OwnerDao ownerDao;

    public OwnerServiceImpl(OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }


    @Override
    public JpaRepository<Owner, String> getDao() {
        return ownerDao;
    }
}
