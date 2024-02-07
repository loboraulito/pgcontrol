package bo.edu.uto.dtic.pgcontrol.mapas;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import bo.edu.uto.dtic.pgcontrol.dominios.Enlace;

@Repository
public interface EnlaceMapper {

	List<Enlace> getMenuByRol(Integer id_rol) throws DataAccessException;
}
