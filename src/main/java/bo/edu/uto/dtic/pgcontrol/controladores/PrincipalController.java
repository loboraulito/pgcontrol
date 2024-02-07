package bo.edu.uto.dtic.pgcontrol.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bo.edu.uto.dtic.pgcontrol.dominios.Rol;
import bo.edu.uto.dtic.pgcontrol.dominios.UsuarioAcceso;
import bo.edu.uto.dtic.pgcontrol.mapas.AccesoMapa;
import bo.edu.uto.dtic.pgcontrol.mapas.AccesoUsuarioMapa;
import bo.edu.uto.dtic.pgcontrol.mapas.RolMapa;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/principal")
@Slf4j
public class PrincipalController {

	@Autowired
	private AccesoMapa accesoMapa;
	@Autowired
	private RolMapa rolesMapa;
	@Autowired
	private AccesoUsuarioMapa accesoUsuarioMapa;

	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		String env = request.getServletContext().getInitParameter("entorno");

		HashMap modelo = new HashMap();
		java.security.Principal x = request.getUserPrincipal();
		UsuarioAcceso datos = (UsuarioAcceso) accesoMapa.getUsuario(x.getName());
		Rol aux = new Rol();
		aux.setId_usuario(datos.getId_usuario());
		aux.setId_sistema(5);
		List<Rol> roles = rolesMapa.getRoles(aux);
		HttpSession ses = request.getSession();
		ses.setAttribute("__direccion", "/pgcontrol/");
		ses.setAttribute("usuarioacceso", datos);
		ses.setAttribute("roles", roles);
		log.info(roles.toString());
		modelo.put("apodo", x.getName());
		return new ModelAndView("principal/index", modelo);
	}

	@RequestMapping("/home")
	public ModelAndView cabecera(HttpSession hs) {
		Map modelo = new HashMap();
		UsuarioAcceso usuarioAcceso = accesoMapa.getUsuario("raulv");
		System.out.println("usuario: " +usuarioAcceso.toString());
		return new ModelAndView("home", modelo);
	}
	@GetMapping("/hello")
		public String showForm(ModelAndView model) {
			model.addObject("holas", "bolas");
		return "hello";
	}

	@RequestMapping("/denegado")
	public ModelAndView denegado(HttpSession hs) {
		Map modelo = new HashMap();
		// Verificando si el Usuario sigue autentificado.
		Integer id_usuario = (Integer) hs.getAttribute("__id_usuario");
		modelo.put("logout", id_usuario == null);

		return new ModelAndView("principal/denegado", modelo);
	}

	@RequestMapping(value = "/loginStatus")
	@ResponseBody
	public ResponseEntity<?> loginStatus(HttpServletRequest request, HttpServletResponse response, HttpSession hs) {
		Map modelo = new HashMap();
		// Verificando si el Usuario sigue autentificado.
		UsuarioAcceso usuario = (UsuarioAcceso) hs.getAttribute("usuarioacceso");
		modelo.put("logout", usuario.getId_usuario() == null);

		return new ResponseEntity(modelo, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/verificarRol")
	@ResponseBody
	public ResponseEntity<?> verificarRol(HttpServletRequest request, HttpServletResponse response, HttpSession hs, Integer id_rol) {
		Map modelo = new HashMap();
		List<Rol> roles = (List<Rol>) hs.getAttribute("roles");
		Rol rol = null;
		for(Rol roli:roles){
			if(roli.getId_rol() == id_rol)
				rol = roli;
		}
		modelo.put("rolActivo", rol != null);

		return new ResponseEntity(modelo, HttpStatus.CREATED);
	}
}
