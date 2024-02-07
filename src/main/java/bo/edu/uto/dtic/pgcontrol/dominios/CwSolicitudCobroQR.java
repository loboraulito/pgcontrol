package bo.edu.uto.dtic.pgcontrol.dominios;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CwSolicitudCobroQR implements java.io.Serializable {
	private Integer id_cw_solicitud_cobro_qr;
	private Integer id_estudiante;
	private Integer id_persona;
	@JsonFormat(timezone = "GMT-04:00")
	private Date fecha_generacion;
	private Integer id_pago;
	private Integer id_rcobro;
	@JsonFormat(timezone = "GMT-04:00")
	private Date fecha_pago;
	private Integer id_usuario;
	@JsonFormat(timezone = "GMT-04:00")
	private Date fecha_modificacion;
	private Integer qrid;
	private String currency;
	private String gloss;
	private Double amount;
	@JsonFormat(timezone = "GMT-04:00")
	private Date expirationdate;
	private Boolean singleuse;
	private String additionaldata;
	private Integer destinationaccountid;
	private Boolean success;
	private String message;
	private String estado;
	private Boolean id_estado;
	private String tipocobro;
	private Integer id_valor;

	private String nombre;
	private String dip;
}
