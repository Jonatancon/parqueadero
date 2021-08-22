package cesde.net.parqueadero.domain.services;

import cesde.net.parqueadero.data.daos.CarDao;
import cesde.net.parqueadero.data.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarServiceImpl {

    @Autowired
    private CarDao carDao;

    public void save (Car car) {
        carDao.save(car);
    }

    public Car get(String idCar) {
        return carDao.findById(idCar).get();
    }

    public Boolean existCar (String car) {
        return carDao.existsById(car);
    }


}
