package bo.edu.uto.dtic.pgcontrol.dominios;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class AccesoUsuario implements java.io.Serializable {
	private Integer id_unidad_usuario;
	private Integer id_usuario;
	private String id_facultad;
	private Integer id_unidad;

	private List<Rol> roles;
}
