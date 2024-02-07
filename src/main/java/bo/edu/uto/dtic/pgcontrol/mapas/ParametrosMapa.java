package bo.edu.uto.dtic.pgcontrol.mapas;

import java.util.Date;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import bo.edu.uto.dtic.pgcontrol.dominios.Parametro;

/**
 *
 * @author dtic
 */
@Repository
public interface ParametrosMapa {

	List getFacultades() throws DataAccessException;
	List getUnidades(String id_facultad) throws DataAccessException;
	Parametro getNumeroResolucion() throws DataAccessException;
	void setNumeroResolucion(Integer numResolucion) throws DataAccessException;
	Parametro getFechaResolucion() throws DataAccessException;
	void setFechaResolucion(Date fechaResolucionDate) throws DataAccessException;
}
