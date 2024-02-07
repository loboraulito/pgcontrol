package bo.edu.uto.dtic.sim.controladores;

import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/prueba")
public class PruebaController {
	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		String env = request.getServletContext().getInitParameter("entorno");

		HashMap modelo = new HashMap();

		return new ModelAndView("dashboard/analytics", modelo);
	}
}