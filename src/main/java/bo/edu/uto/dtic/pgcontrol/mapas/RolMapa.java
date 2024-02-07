package bo.edu.uto.dtic.pgcontrol.mapas;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import bo.edu.uto.dtic.pgcontrol.dominios.Rol;

@Repository
public interface RolMapa {

	List<Rol> getRoles(Rol rol) throws DataAccessException;

}