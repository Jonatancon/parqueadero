package cesde.net.parqueadero.domain.services.impl;

import cesde.net.parqueadero.commons.GenericServiceImpl;
import cesde.net.parqueadero.data.daos.PersonDao;
import cesde.net.parqueadero.data.model.Person;
import cesde.net.parqueadero.domain.services.access.PersonService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends GenericServiceImpl<Person,Long> implements PersonService {

    private final PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }


    @Override
    public JpaRepository<Person, Long> getDao() {
        return personDao;
    }
}
