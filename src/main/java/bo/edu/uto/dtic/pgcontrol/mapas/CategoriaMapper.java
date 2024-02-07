package bo.edu.uto.dtic.pgcontrol.mapas;

import java.util.List;

import org.springframework.stereotype.Repository;

import bo.edu.uto.dtic.pgcontrol.dominios.Categoria;

@Repository
public interface CategoriaMapper {
	public List<Categoria> getAll();
	public List<Categoria> getAllByIdEstado(Boolean id_estado);
	public Categoria getById(Integer id);
	public int insert(Categoria dato);
	public int update(Categoria dato);
	public int delete(Integer id);
}