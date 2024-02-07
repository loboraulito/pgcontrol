package bo.edu.uto.dtic.sim.dominios;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Unidad {
	private Integer id_unidad;
	private String unidad;
	private String id_facultad;
	private String codigo;
}
