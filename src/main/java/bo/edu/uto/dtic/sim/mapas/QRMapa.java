package bo.edu.uto.dtic.sim.mapas;

import bo.edu.uto.dtic.sim.dominios.CwSolicitudCobroQR;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public interface QRMapa {

	List<CwSolicitudCobroQR> listarSolicitudes(CwSolicitudCobroQR solicitud) throws DataAccessException;

}
