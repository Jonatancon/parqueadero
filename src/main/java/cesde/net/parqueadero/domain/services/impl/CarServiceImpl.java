package cesde.net.parqueadero.domain.services.impl;

import cesde.net.parqueadero.commons.GenericServiceImpl;
import cesde.net.parqueadero.data.daos.CarDao;
import cesde.net.parqueadero.data.model.Car;
import cesde.net.parqueadero.domain.services.access.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends GenericServiceImpl<Car,String> implements CarService {

    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }


    @Override
    public JpaRepository<Car, String> getDao() {
        return carDao;
    }
}
