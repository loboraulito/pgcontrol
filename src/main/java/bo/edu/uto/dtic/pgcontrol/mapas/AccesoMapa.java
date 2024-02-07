package bo.edu.uto.dtic.pgcontrol.mapas;

import bo.edu.uto.dtic.pgcontrol.dominios.UsuarioAcceso;

public interface AccesoMapa {
	//public List getDatosUsuario(String apodo);
	public UsuarioAcceso getUsuario(String apodo);
	//public UsuarioAcceso getUsuarioByIdUsuario(Integer id_usuario);
	//public List<Rol> getRolList(Integer id_usuario);
	//public List<Enlace> getEnlacesMenu(Integer id_rol);
	//public int getRolUsr(String usuario);
}
