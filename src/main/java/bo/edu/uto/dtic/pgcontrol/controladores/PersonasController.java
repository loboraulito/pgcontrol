package bo.edu.uto.dtic.pgcontrol.controladores;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bo.edu.uto.dtic.pgcontrol.mapas.PersonasMapa;

/**
 *
 * @author dtic
 */
@Controller
@RequestMapping("/personas")
public class PersonasController {

	@Autowired
	private PersonasMapa personasMapa;

	@RequestMapping
	@ResponseBody
	public List buscarPersonas(String term, HttpServletRequest hsr, HttpSession hs) {
		HashMap modelo = new HashMap();
		// Verificando si el Usuario sigue autentificado.
		Integer id_usuario = (Integer) hs.getAttribute("__id_usuario");
		modelo.put("logout", id_usuario == null);
		//
		term = "%" + term.trim().replaceAll("\\s+", "%") + "%";
		//
		List lista = personasMapa.buscarPersonas(term);
		//
		modelo.put("lista", lista);

		return lista;
	}
}
