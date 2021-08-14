package cesde.net.parqueadero.data.daos;

import cesde.net.parqueadero.data.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractDao extends JpaRepository<Contract,Long> {
}
