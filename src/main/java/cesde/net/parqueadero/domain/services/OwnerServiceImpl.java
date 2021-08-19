package cesde.net.parqueadero.domain.services;

import cesde.net.parqueadero.data.daos.OwnerDao;
import cesde.net.parqueadero.data.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OwnerServiceImpl  {

    @Autowired
    private OwnerDao ownerDao;

    public Owner get(String dni) {
        return ownerDao.getById(dni);
    }

    public Boolean existDni (String dni) {
        return ownerDao.existsById(dni);
    }

    public void saveOwner (Owner owner) {
        ownerDao.save(owner);
    }

}
