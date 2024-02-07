package bo.edu.uto.dtic.pgcontrol.mapas;

import java.util.List;
import org.springframework.stereotype.Repository;

import bo.edu.uto.dtic.pgcontrol.dominios.AccesoUsuario;
import bo.edu.uto.dtic.pgcontrol.dominios.Usuarios;

/**
 *
 * @author dtic
 */
@Repository
public interface AccesoUsuarioMapa {

	List<AccesoUsuario> getAccesosUsuario (Usuarios usuario);
}
