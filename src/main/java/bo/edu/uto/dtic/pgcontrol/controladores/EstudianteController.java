package bo.edu.uto.dtic.pgcontrol.controladores;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bo.edu.uto.dtic.pgcontrol.mapas.PersonasMapa;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author dtic
 */
@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

	@Autowired
	private PersonasMapa personasMapa;

	@RequestMapping("/ficha_inscripcion")
	@ResponseBody
	public ModelAndView ficha_inscripcion(String term, HttpServletRequest hsr, HttpSession hs) {
		HashMap modelo = new HashMap();
		Integer id_usuario = (Integer) hs.getAttribute("__id_usuario");
		return new ModelAndView("estudiante/ficha_inscripcion", modelo);
	}
}