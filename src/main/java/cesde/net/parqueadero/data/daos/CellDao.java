package cesde.net.parqueadero.data.daos;

import cesde.net.parqueadero.data.model.Cell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CellDao extends JpaRepository<Cell, Long> {
}
