package cesde.net.parqueadero.data.daos;

import cesde.net.parqueadero.data.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDao extends JpaRepository<Car, String> {
}
