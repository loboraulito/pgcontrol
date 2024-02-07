package bo.edu.uto.dtic.sim.mapas;

import bo.edu.uto.dtic.sim.dominios.Enlace;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public interface EnlaceMapper {

	List<Enlace> getMenuByRol(Integer id_rol) throws DataAccessException;
}
