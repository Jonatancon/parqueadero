package cesde.net.parqueadero.data.daos;

import cesde.net.parqueadero.data.model.Car;
import cesde.net.parqueadero.data.model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingLotDao extends JpaRepository<ParkingLot,Long> {

    ParkingLot findByCarAndActiveIsTrue (Car car);

    Optional<ParkingLot> findAllByActiveIsTrue ();

    Boolean existsByCarAndActiveIsTrue (Car car);
}
