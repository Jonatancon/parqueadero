package cesde.net.parqueadero.domain.services.impl;

import cesde.net.parqueadero.commons.GenericServiceImpl;
import cesde.net.parqueadero.data.daos.ParkingLotDao;
import cesde.net.parqueadero.data.model.ParkingLot;
import cesde.net.parqueadero.domain.services.access.ParkingLotService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotServiceImpl extends GenericServiceImpl<ParkingLot,Long> implements ParkingLotService {

    private final ParkingLotDao parkingLotDao;

    public ParkingLotServiceImpl(ParkingLotDao parkingLotDao) {
        this.parkingLotDao = parkingLotDao;
    }


    @Override
    public JpaRepository<ParkingLot, Long> getDao() {
        return parkingLotDao;
    }
}
