package bo.edu.uto.dtic.pgcontrol.dominios;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CwNotificacionPagoQR implements java.io.Serializable {
	private Integer id_cw_notificacion_pago_qr;
	@JsonProperty("QRId")
	private Integer QRId;
	@JsonProperty("Gloss")
	private String Gloss;
	private String sourceBankId;
	private String originName;
	@JsonProperty("VoucherId")
	private String VoucherId;
	@JsonProperty("TransactionDateTime")
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss", timezone = "GMT-04:00")
	private Date TransactionDateTime;
	private String additionalData;
	private Integer id_cw_solicitud_cobro_qr;
	private String estado;
	private Boolean id_estado;
}
