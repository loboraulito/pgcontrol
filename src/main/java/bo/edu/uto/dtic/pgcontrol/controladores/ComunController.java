package bo.edu.uto.dtic.pgcontrol.controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bo.edu.uto.dtic.pgcontrol.dominios.Enlace;
import bo.edu.uto.dtic.pgcontrol.dominios.Rol;
import bo.edu.uto.dtic.pgcontrol.mapas.AccesoMapa;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/comun")
public class ComunController {

	@Autowired
	private AccesoMapa accesoMapa;

	@RequestMapping("/cabecera")
	public ModelAndView cabecera(HttpSession hs) {
		Map modelo = new HashMap();
//		modelo.put("apodo", hs.getAttribute("__apodo"));
//		modelo.put("nombre", hs.getAttribute("__nombre_completo"));
		return new ModelAndView("comun/cabecera", modelo);
	}

	@RequestMapping("/cabecera_2")
	public ModelAndView cabecera_2(HttpSession hs) {
		Map modelo = new HashMap();
		return new ModelAndView("comun/cabecera_2", modelo);
	}

	@RequestMapping("/menu")
	public ModelAndView menu(Integer idRol) {
		Map modelo = new HashMap();
		List<Enlace> menus = new ArrayList<>();
		modelo.put("menus", menus);
		return new ModelAndView("comun/menu", modelo);
	}

	@RequestMapping("/roles")
	public ModelAndView roles(HttpSession hs) {
		Map modelo = new HashMap();
		List<Rol> roles = new ArrayList<>();
		modelo.put("apodo", (String) hs.getAttribute("__apodo"));
		modelo.put("roles", roles);
		return new ModelAndView("comun/roles", modelo);
	}

	@RequestMapping("/pie")
	public ModelAndView pie() {
		return new ModelAndView("comun/pie");
	}

	@RequestMapping("/denegado")
	public ModelAndView denegado(HttpServletResponse hsr) {
		return new ModelAndView("comun/denegado");
	}

	@RequestMapping("/500error")
	public ModelAndView error500(HttpServletResponse hsr) {
		new Exception("error generado");
		return new ModelAndView("comun/denegado");
	}
}
