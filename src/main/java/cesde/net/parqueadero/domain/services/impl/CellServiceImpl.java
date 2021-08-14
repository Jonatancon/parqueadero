package cesde.net.parqueadero.domain.services.impl;

import cesde.net.parqueadero.commons.GenericServiceImpl;
import cesde.net.parqueadero.data.daos.CellDao;
import cesde.net.parqueadero.data.model.Cell;
import cesde.net.parqueadero.domain.services.access.CellService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CellServiceImpl extends GenericServiceImpl<Cell,Long> implements CellService {

    private final CellDao cellDao;

    public CellServiceImpl(CellDao cellDao) {
        this.cellDao = cellDao;
    }


    @Override
    public JpaRepository<Cell, Long> getDao() {
        return cellDao;
    }
}
