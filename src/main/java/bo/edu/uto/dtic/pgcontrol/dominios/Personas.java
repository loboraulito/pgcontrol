package bo.edu.uto.dtic.pgcontrol.dominios;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Personas implements java.io.Serializable {
	private Integer id_persona;
	private String nombres;
	private String paterno;
	private String materno;
	private String nombre;
	private boolean id_estado;
	private String dip;
	private Date fec_nacimiento;
	private String direccion;
	private String telefono;
	private String celular;
}
