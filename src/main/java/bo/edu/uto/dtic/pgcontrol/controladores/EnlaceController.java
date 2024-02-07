package bo.edu.uto.dtic.pgcontrol.controladores;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bo.edu.uto.dtic.pgcontrol.dominios.Enlace;
import bo.edu.uto.dtic.pgcontrol.mapas.EnlaceMapper;

@Controller
@RequestMapping("/enlaces")
@Slf4j
public class EnlaceController {

	@Autowired
	EnlaceMapper enlaceMapper;

	@RequestMapping(value = "/renderMenu")
	public ModelAndView renderMenu(HttpServletRequest request, HttpServletResponse response, Integer id_rol) {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		List<Enlace> menu = enlaceMapper.getMenuByRol(id_rol);
		respuesta.put("menu", menu);
		return new ModelAndView("enlaces/menu", respuesta);
	}

	@RequestMapping(value = "/listar")
	@ResponseBody
	public ResponseEntity<?> listar(HttpServletRequest request, HttpServletResponse response, Integer id_rol) {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("correcto",true);
		respuesta.put("menu", enlaceMapper.getMenuByRol(id_rol));
		return new ResponseEntity(respuesta, HttpStatus.OK);
	}
}
