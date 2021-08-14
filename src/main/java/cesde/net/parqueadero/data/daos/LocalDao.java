package cesde.net.parqueadero.data.daos;

import cesde.net.parqueadero.data.model.Local;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalDao extends JpaRepository<Local,Long> {
}
