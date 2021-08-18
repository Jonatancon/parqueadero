package cesde.net.parqueadero.domain.services;

import cesde.net.parqueadero.data.daos.CellDao;
import cesde.net.parqueadero.data.model.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CellServiceImpl {

    @Autowired
    private CellDao cellDao;
}
