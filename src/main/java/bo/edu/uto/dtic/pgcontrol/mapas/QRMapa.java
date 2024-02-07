package bo.edu.uto.dtic.pgcontrol.mapas;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import bo.edu.uto.dtic.pgcontrol.dominios.CwSolicitudCobroQR;

@Repository
public interface QRMapa {

	List<CwSolicitudCobroQR> listarSolicitudes(CwSolicitudCobroQR solicitud) throws DataAccessException;

}
