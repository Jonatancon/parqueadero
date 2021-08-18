package cesde.net.parqueadero.data.daos;

import cesde.net.parqueadero.data.model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotDao extends JpaRepository<ParkingLot,Long> {
}
