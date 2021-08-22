package cesde.net.parqueadero.data.daos;

import cesde.net.parqueadero.data.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerDao extends JpaRepository<Owner,String> {
}
