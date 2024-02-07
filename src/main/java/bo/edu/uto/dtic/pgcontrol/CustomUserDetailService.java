package bo.edu.uto.dtic.pgcontrol;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bo.edu.uto.dtic.pgcontrol.dominios.Rol;
import bo.edu.uto.dtic.pgcontrol.dominios.UsuarioAcceso;
import bo.edu.uto.dtic.pgcontrol.mapas.AccesoMapa;
import bo.edu.uto.dtic.pgcontrol.mapas.RolMapa;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	AccesoMapa accesoMapa;
	@Autowired
	RolMapa rolesMapa;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioAcceso usuario = accesoMapa.getUsuario(username);
		if (null == usuario) {
			throw new UsernameNotFoundException("Usuario NO Registrado");
		}
		List<GrantedAuthority> rolesAuth = new ArrayList<>();
		List<Rol> roles = new ArrayList<Rol>();
		Rol aux = new Rol();
		aux.setId_usuario(usuario.getId_usuario());
		//TODO generalizar del parametro application.properties
		aux.setId_sistema(5);
		roles = rolesMapa.getRoles(aux);
		usuario.setRoles(roles);
		for (Rol rol : roles) {
			rolesAuth.add(new SimpleGrantedAuthority("ROLE_"+rol.getId_rol()));
		}
		//rolesAuth.add(new SimpleGrantedAuthority("ROLE_USER"));
		System.out.println("auths");
		for(GrantedAuthority auth:rolesAuth)
			System.out.println(auth.getAuthority());
		boolean enabled = (Boolean) true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		UserDetails user = new User(
				usuario.getApodo(), usuario.getClave2(),
				enabled,
				accountNonExpired,
				credentialsNonExpired,
				accountNonLocked,
				rolesAuth);
		return user;
	}
}
