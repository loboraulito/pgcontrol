package bo.edu.uto.dtic.sim.dominios;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Enlace implements java.io.Serializable {
	private Integer id_enlace;
	private Integer id_enlace_padre;
	private Boolean id_estado;
	private Integer orden;
	private Integer nivel;
	private String enlace;
	private String ruta;
	private String posicion;

	private Integer id_rol;
	private List<Enlace> enlaces;
}
