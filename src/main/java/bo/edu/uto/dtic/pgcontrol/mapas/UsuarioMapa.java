package bo.edu.uto.dtic.pgcontrol.mapas;

import java.util.List;

import bo.edu.uto.dtic.pgcontrol.dominios.UsuarioAcceso;

public interface UsuarioMapa {
	List<UsuarioAcceso> getUsuarios();
	List<UsuarioAcceso> getUsuariosDetalle();
	UsuarioAcceso getUsuario(UsuarioAcceso usuario);
	UsuarioAcceso insertarUsuario(UsuarioAcceso usuario);
	int borrarUsuario(UsuarioAcceso usuario);
}