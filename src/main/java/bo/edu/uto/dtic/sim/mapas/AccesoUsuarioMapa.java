package bo.edu.uto.dtic.sim.mapas;

import bo.edu.uto.dtic.sim.dominios.AccesoUsuario;
import bo.edu.uto.dtic.sim.dominios.Usuarios;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dtic
 */
@Repository
public interface AccesoUsuarioMapa {

	List<AccesoUsuario> getAccesosUsuario (Usuarios usuario);
}
