package cesde.net.parqueadero.data.daos;

import cesde.net.parqueadero.data.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDao extends JpaRepository<Car, String> {
}
