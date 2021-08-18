package cesde.net.parqueadero.domain.services.impl;

import cesde.net.parqueadero.commons.GenericServiceImpl;
import cesde.net.parqueadero.data.daos.PersonDao;
import cesde.net.parqueadero.data.model.Person;
import cesde.net.parqueadero.domain.services.access.PersonService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PersonServiceImpl extends GenericServiceImpl<Person,Long> implements PersonService {

    private final PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    public Optional<Person> getByDni (String dni) {
        return personDao.findByDni(dni);
    }

    public Boolean existsByDni (String dni) {
        return personDao.existsByDni(dni);
    }

    @Override
    public JpaRepository<Person, Long> getDao() {
        return personDao;
    }
}
