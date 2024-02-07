package bo.edu.uto.dtic.pgcontrol.controladores;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

import bo.edu.uto.dtic.pgcontrol.dominios.CwSolicitudCobroQR;
import bo.edu.uto.dtic.pgcontrol.mapas.QRMapa;

@Controller
@RequestMapping("/qr")
public class QRController {
	@Autowired
	QRMapa qrMapa;

	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		HashMap modelo = new HashMap();
		return new ModelAndView("principal/index", modelo);
	}

	@RequestMapping(value = "/listarSolicitudes")
	@ResponseBody
	public ResponseEntity<?> listarSolicitudes(CwSolicitudCobroQR dato) {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		HttpStatus estado = HttpStatus.OK;
		List resultado = null;
		try {
			resultado = qrMapa.listarSolicitudes(dato);
			respuesta.put("resultado", resultado);
			if (resultado == null) {
				respuesta.put("mensaje", "No existen registros con los criterios solicitados: ");
				estado = HttpStatus.NOT_FOUND;
			}
		} catch (Exception e) {
			respuesta.put("mensaje", "Error al realizar la consulta.");
			respuesta.put("debug", e.toString());
			estado = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Object>(respuesta, estado);
	}

	@RequestMapping(value = "/listarSolicitudesTabla")
	public ModelAndView listarSolicitudesTabla(HttpServletRequest request, HttpServletResponse response, CwSolicitudCobroQR dato) {
		HashMap modelo = new HashMap();
		if(dato!=null){
			if(dato.getTipocobro()=="")
				dato.setTipocobro(null);
			if(dato.getNombre()=="")
				dato.setNombre(null);
		}
		List solicitudes = qrMapa.listarSolicitudes(dato);
		modelo.put("solicitudes", solicitudes);
		return new ModelAndView("/qr/lista", modelo);
	}
}
