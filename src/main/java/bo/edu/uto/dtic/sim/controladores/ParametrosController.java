package bo.edu.uto.dtic.sim.controladores;

import bo.edu.uto.dtic.sim.mapas.ParametrosMapa;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/parametros")
public class ParametrosController {

	@Autowired
	ParametrosMapa parametrosMapa;

	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		return new ModelAndView("parametros/index", respuesta);
	}

	@RequestMapping(value = "/listar")
	@ResponseBody
	public ResponseEntity<?> listar(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> respuesta = new HashMap<String, Object>();

		respuesta.put("correcto",true);
		respuesta.put("parametroNumeroResolucion", parametrosMapa.getNumeroResolucion());
		respuesta.put("parametroFechaResolucion", parametrosMapa.getFechaResolucion());
		return new ResponseEntity(respuesta, HttpStatus.OK);
	}

	@RequestMapping(value = "/guardar")
	@ResponseBody
	public ResponseEntity<?> guardar(
			HttpServletRequest request
			, HttpServletResponse response
			, HttpSession session
			, Integer numResolucion
			, String fechaResolucion
	) throws ParseException {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		Date fechaResolucionDate = (new SimpleDateFormat("yyyy-MM-dd")).parse(fechaResolucion);

		try {
			parametrosMapa.setNumeroResolucion(numResolucion);
			parametrosMapa.setFechaResolucion(fechaResolucionDate);
		} catch (Exception e) {
			respuesta.put("correcto",false);
			respuesta.put("mensaje", "Error al realizar la operación");
			e.printStackTrace();
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		respuesta.put("correcto",true);
		return new ResponseEntity(respuesta, HttpStatus.OK);
	}

}
