package cesde.net.parqueadero.data.daos;

import cesde.net.parqueadero.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonDao extends JpaRepository<Person,Long> {
    Optional<Person> findByDni(String dni);
    Boolean existsByDni (String dni);
}
