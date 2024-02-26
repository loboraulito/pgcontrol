package bo.edu.uto.dtic.pgcontrol.controladores;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bo.edu.uto.dtic.pgcontrol.mapas.UsuarioMapa;

/**
 *
 * @author dtic
 */
@Controller
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	UsuarioMapa usuarioMapa;

	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		HashMap modelo = new HashMap();
		List usuarios = usuarioMapa.getUsuariosDetalle();
		modelo.put("usuarios", usuarios);
		return new ModelAndView("administrador/index", modelo);
	}

}
