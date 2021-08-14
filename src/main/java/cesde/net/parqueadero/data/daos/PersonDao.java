package cesde.net.parqueadero.data.daos;

import cesde.net.parqueadero.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person,Long> {
}
