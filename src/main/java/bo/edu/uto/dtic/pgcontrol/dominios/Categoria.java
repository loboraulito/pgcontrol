package bo.edu.uto.dtic.pgcontrol.dominios;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Categoria {
	private Integer id_categoria;
	private String categoria;
	private String estado;
	private Boolean id_estado;
	private Integer id_ult_usu;
	private Date fecha_modificacion;
	private Integer id_categoria_padre;

	private List<Categoria> categorias;
}
