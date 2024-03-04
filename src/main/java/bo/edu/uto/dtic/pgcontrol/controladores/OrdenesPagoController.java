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
@RequestMapping("/ordenes")
public class OrdenesPagoController {

	@Autowired
	private PersonasMapa personasMapa;

	@RequestMapping("/porPrograma")
	@ResponseBody
	public ModelAndView ficha_inscripcion(String term, HttpServletRequest hsr, HttpSession hs) {
		HashMap modelo = new HashMap();
		Integer id_usuario = (Integer) hs.getAttribute("__id_usuario");
		return new ModelAndView("ordenes/porPrograma", modelo);
	}
	@RequestMapping("/listaPendientes")
	@ResponseBody
	public ModelAndView listaPendientes(String term, HttpServletRequest hsr, HttpSession hs) {
		HashMap modelo = new HashMap();
		Integer id_usuario = (Integer) hs.getAttribute("__id_usuario");
		return new ModelAndView("ordenes/listaPendientes", modelo);
	}
	@RequestMapping("/reporte")
	@ResponseBody
	public ModelAndView reporte(String term, HttpServletRequest hsr, HttpSession hs) {
		HashMap modelo = new HashMap();
		Integer id_usuario = (Integer) hs.getAttribute("__id_usuario");
		return new ModelAndView("ordenes/reporte", modelo);
	}
}