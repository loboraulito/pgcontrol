
package bo.edu.uto.dtic.pgcontrol.dominios;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CriterioBusqueda {
	private String tipoBusqueda;
	private String cadenaBusqueda;
	private String inicio;
	private String offset;
	private int entero1;
	private int entero2;
	private int entero3;
	private String cadena1;
	private String cadena2;
	private String cadena3;
	private Integer id_unidad;
	private String facultad;
	private Integer id_persona;
	private Integer gestion;
	private String id_facultad_busqueda;
	private Integer id_unidad_busqueda;
}
