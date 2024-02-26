package bo.edu.uto.dtic.pgcontrol.controladores;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bo.edu.uto.dtic.pgcontrol.mapas.PersonasMapa;

/**
 *
 * @author dtic
 */
@Controller
@RequestMapping("/programas")
public class ProgramasController {

	@Autowired
	private PersonasMapa personasMapa;

	@RequestMapping("/index")
	@ResponseBody
	public ModelAndView index(String term, HttpServletRequest hsr, HttpSession hs) {
		HashMap modelo = new HashMap();
		Integer id_usuario = (Integer) hs.getAttribute("__id_usuario");
		return new ModelAndView("programas/index", modelo);
	}

	@RequestMapping("/nuevo")
	@ResponseBody
	public ModelAndView nuevo(String term, HttpServletRequest hsr, HttpSession hs) {
		HashMap modelo = new HashMap();
		Integer id_usuario = (Integer) hs.getAttribute("__id_usuario");
		return new ModelAndView("programas/nuevo", modelo);
	}

	@RequestMapping("/editar")
	@ResponseBody
	public ModelAndView editar(String term, HttpServletRequest hsr, HttpSession hs) {
		HashMap modelo = new HashMap();
		Integer id_usuario = (Integer) hs.getAttribute("__id_usuario");
		return new ModelAndView("programas/editar", modelo);
	}
}
