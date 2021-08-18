package cesde.net.parqueadero.domain.services;

import cesde.net.parqueadero.data.daos.RolDao;
import cesde.net.parqueadero.data.model.Rol;
import cesde.net.parqueadero.data.model.enums.RolName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolServiceImpl {

    @Autowired
    private RolDao rolDao;

    public Optional<Rol> getByRolName (RolName rolName) {
        return rolDao.findByRolName(rolName);
    }

    public void save (Rol rol) {
        rolDao.save(rol);
    }
}
