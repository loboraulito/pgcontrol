package bo.edu.uto.dtic.sim.mapas;

import bo.edu.uto.dtic.sim.dominios.Personas;
import java.util.List;
import org.springframework.dao.DataAccessException;


/**
 *
 * @author dtic
 */
public interface PersonasMapa {

	public List<Personas> buscarPersonas(String term)throws DataAccessException;
}
