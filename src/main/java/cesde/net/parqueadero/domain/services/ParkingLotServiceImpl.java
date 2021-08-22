package cesde.net.parqueadero.domain.services;

import cesde.net.parqueadero.data.daos.ParkingLotDao;
import cesde.net.parqueadero.data.model.Car;
import cesde.net.parqueadero.data.model.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ParkingLotServiceImpl {

    @Autowired
    private ParkingLotDao parkingLotDao;

    public void save (ParkingLot parkingLot) {
        parkingLotDao.save(parkingLot);
    }

    public ParkingLot findCarActive (Car car) {
        return parkingLotDao.findByCarAndActiveIsTrue(car);
    }

    public Optional<List<ParkingLot>> findAllActives () {
        return parkingLotDao.findAllByActiveTrue();
    }

    public Boolean existCarActive (Car car) {
        return parkingLotDao.existsByCarAndActiveIsTrue(car);
    }

    public ParkingLot findParking(Long id) {
        return parkingLotDao.findById(id).get();
    }

    public Boolean existById(Long id) {
        return parkingLotDao.existsById(id);
    }


}
