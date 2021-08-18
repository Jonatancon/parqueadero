package cesde.net.parqueadero.domain.services;

import cesde.net.parqueadero.data.daos.PersonDao;
import cesde.net.parqueadero.data.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PersonServiceImpl {

    @Autowired
    private PersonDao personDao;


    public Optional<Person> getByDni (String dni) {
        return personDao.findByDni(dni);
    }

    public void save (Person person) {
        personDao.save(person);
    }

    public Boolean existsByDni (String dni) {
        return personDao.existsByDni(dni);
    }

}
