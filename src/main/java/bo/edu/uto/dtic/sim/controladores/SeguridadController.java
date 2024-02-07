package bo.edu.uto.dtic.sim.controladores;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/seguridad")
public class SeguridadController {

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		return new ModelAndView("seguridad/login");
	}

	@RequestMapping("/error")
	public ModelAndView error(HttpServletRequest request, String consulta, String dip, Date fec_nacimiento) {
		HashMap modelo = new HashMap();
		modelo.put("consulta", consulta);
		return new ModelAndView("seguridad/error", modelo);
	}
}
