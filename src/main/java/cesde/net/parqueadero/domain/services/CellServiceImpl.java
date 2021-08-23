package cesde.net.parqueadero.domain.services;

import cesde.net.parqueadero.data.daos.CellDao;
import cesde.net.parqueadero.data.model.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CellServiceImpl {

    @Autowired
    private CellDao cellDao;

    public Optional<List<Cell>> getAll () {
        return cellDao.findAllByOcupadoFalse();
    }

    public void update (Cell cell) {
        cellDao.save(cell);
    }

    public Optional<List<Cell>> activeCell () {
        return cellDao.findAllByOcupadoFalseAndReservedFalse();
    }

    public Cell getById(Long id){
        return cellDao.findById(id).get();
    }

}
