package bo.edu.uto.dtic.sim.mapas;

import bo.edu.uto.dtic.sim.dominios.UsuarioAcceso;
import java.util.List;

public interface UsuarioMapa {
	List<UsuarioAcceso> getUsuarios();
	List<UsuarioAcceso> getUsuariosDetalle();
	UsuarioAcceso getUsuario(UsuarioAcceso usuario);
	UsuarioAcceso insertarUsuario(UsuarioAcceso usuario);
	int borrarUsuario(UsuarioAcceso usuario);
}