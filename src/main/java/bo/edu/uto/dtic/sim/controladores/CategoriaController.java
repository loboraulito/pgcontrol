package bo.edu.uto.dtic.sim.controladores;

import bo.edu.uto.dtic.sim.dominios.UsuarioAcceso;
import bo.edu.uto.dtic.sim.dominios.Usuarios;
import bo.edu.uto.dtic.sim.mapas.UsuarioMapa;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dtic
 */
@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private UsuarioMapa usuarioMapa;

	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		HashMap modelo = new HashMap();

		return new ModelAndView("usuario/index", modelo);
	}

	@RequestMapping(value = "/lista")
	public ModelAndView lista(HttpServletRequest request, HttpServletResponse response) {
		HashMap modelo = new HashMap();
		List<UsuarioAcceso> lista = usuarioMapa.getUsuarios();
		modelo.put("lista", lista);
		return new ModelAndView("usuario/lista", modelo);
	}

	@RequestMapping(value = "/listar")
	@ResponseBody
	public Object listar(HttpServletRequest request, HttpServletResponse response) {
		HashMap modelo = new HashMap();
		List<UsuarioAcceso> lista = usuarioMapa.getUsuarios();
		modelo.put("data", lista);
		return modelo;
	}

	@RequestMapping(value = "/listarById")
	public ResponseEntity<?> listarById(Principal principal) {
		HashMap modelo = new HashMap();
		Map<String, Object> response = new HashMap<String, Object>();
		modelo.put("logout", principal==null);

		List dato;
		try {
			dato = usuarioMapa.getUsuariosDetalle();
			response.put("data", dato);
		} catch (Exception e) {
			response.put("mensaje", "Error al realizar la consulta: " + e.toString());
			e.printStackTrace();
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity(response, HttpStatus.OK);
	}
}
