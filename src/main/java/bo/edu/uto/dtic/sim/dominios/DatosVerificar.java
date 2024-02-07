package bo.edu.uto.dtic.sim.dominios;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DatosVerificar{

	private Integer id_estudiante_materia;
	private Integer id_persona;
	private Integer id_materia;
	private Integer id_grupo;
	private Integer id_gestion;
	private Integer id_consulta_estudiantil;
	private Integer id_docente;

	private String dip;
	private Date fec_nacimiento;
}
