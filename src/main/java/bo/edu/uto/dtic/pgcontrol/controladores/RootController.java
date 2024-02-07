package bo.edu.uto.dtic.pgcontrol.controladores;

import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class RootController {
	@RequestMapping("/")
	public ModelAndView cabecera(HttpSession hs) {
		Map modelo = new HashMap();
		return new ModelAndView("redirect:/seguridad/login", modelo);
	}
}
