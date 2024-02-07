package bo.edu.uto.dtic.sim.mapas;

import bo.edu.uto.dtic.sim.dominios.Rol;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public interface RolMapa {

	List<Rol> getRoles(Rol rol) throws DataAccessException;

}