package cesde.net.parqueadero.domain.services;

import cesde.net.parqueadero.data.daos.LocalDao;
import cesde.net.parqueadero.data.model.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LocalServiceImpl {

    @Autowired
    private LocalDao localDao;

    public Local getLocal (Long id) {
        return localDao.findById(id).get();
    }

    public void updateLocal (Local local) {
        localDao.save(local);
    }
}
