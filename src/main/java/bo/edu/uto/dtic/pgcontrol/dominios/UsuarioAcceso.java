package bo.edu.uto.dtic.pgcontrol.dominios;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioAcceso implements java.io.Serializable {

	private Integer id_persona;
	private Integer id_usuario;
	private String apodo;
	private String clave;

	private String clave2;
	private String nombre_completo;
	private String id_facultad;
	private Integer id_unidad;
	private Boolean id_estado;

	private List<Rol> roles;
}
