package cesde.net.parqueadero.domain.services.impl;

import cesde.net.parqueadero.commons.GenericServiceImpl;
import cesde.net.parqueadero.data.daos.LocalDao;
import cesde.net.parqueadero.data.model.Local;
import cesde.net.parqueadero.domain.services.access.LocalService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class LocalServiceImpl extends GenericServiceImpl<Local,Long> implements LocalService {

    private final LocalDao localDao;

    public LocalServiceImpl(LocalDao localDao) {
        this.localDao = localDao;
    }


    @Override
    public JpaRepository<Local, Long> getDao() {
        return localDao;
    }
}
