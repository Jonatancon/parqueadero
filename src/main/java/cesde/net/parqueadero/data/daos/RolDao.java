package cesde.net.parqueadero.data.daos;

import cesde.net.parqueadero.data.model.Rol;
import cesde.net.parqueadero.data.model.enums.RolName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolDao extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRolName (RolName rolName);
}
