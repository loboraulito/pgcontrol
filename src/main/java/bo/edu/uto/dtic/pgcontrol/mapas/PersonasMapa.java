package bo.edu.uto.dtic.pgcontrol.mapas;

import java.util.List;
import org.springframework.dao.DataAccessException;

import bo.edu.uto.dtic.pgcontrol.dominios.Personas;


/**
 *
 * @author dtic
 */
public interface PersonasMapa {

	public List<Personas> buscarPersonas(String term)throws DataAccessException;
}
