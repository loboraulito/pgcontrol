package bo.edu.uto.dtic.pgcontrol.dominios;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Facultad {
	private String id_facultad;
	private String facultad;
	private String direccion;
	private String telefonos;
	private String fec_creacion;
	private String abrev;
	private String codigo;
	private String gestion;
	private String id_estado;
	private String periodo_academico;
	private String firma1;
	private String firma2;
	private String postular;
	private String registro_materia;

	private List<Unidad> unidades;
}
