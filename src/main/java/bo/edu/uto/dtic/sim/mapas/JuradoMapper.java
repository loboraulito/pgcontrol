package bo.edu.uto.dtic.teu.models.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import bo.edu.uto.dtic.commons.models.teu.Jurado;
import bo.edu.uto.dtic.teu.models.JuradoExtendido;
import bo.edu.uto.dtic.teu.models.VerificarEleccion;

@Repository
public interface JuradoMapper {
	@Select("select * from teu.jurados")
	public List<Jurado> getAll();

	@Select("select e.* from teu.jurados e where e.id_estado = #{ id_estado }")
	public List<Jurado> getAllByIdEstado(Boolean id_estado);

	@Select("select e.* from teu.jurados e where e.id_jurado = #{ id }")
	public Jurado getById(Integer id);

	@Insert(
			"INSERT INTO teu.jurados " +
			"(id_eleccion_org, id_persona, id_estado, ult_usuario, fec_reg, id_tipo_elector) " +
			"VALUES(" +
			"#{ id_eleccion_org }, #{ id_persona }, #{ id_estado }, #{ ult_usuario }, #{ fec_reg }, #{ id_tipo_elector }" +
			");"
			)
	@Options(useGeneratedKeys = true, keyProperty = "id_jurado")
	public int insert(Jurado dato);

	@Update("UPDATE teu.jurados " +
			"SET "+
				" id_eleccion_org = #{ id_eleccion_org }, " +
				" id_persona = #{ id_persona }, " +
				" id_estado = #{ id_estado }, " +
				" ult_usuario = #{ ult_usuario }, " +
				" fec_reg = #{ fec_reg }, " +
				" id_tipo_elector = #{ id_tipo_elector } " +
			"WHERE id_jurado= #{ id_jurado };"
			)
	public int update(Jurado dato);

	@Delete("DELETE FROM teu.jurados " +
			"WHERE id_jurado=#{ id };")
	public int delete(Integer id);

	@Delete("DELETE FROM teu.jurados " +
			"WHERE "
			+" id_eleccion_org = #{ id_eleccion_org }"
			+"	AND id_tipo_elector = #{ id_tipo_elector };")
	public int deleteById_eleccion_orgAndId_tipo_elector(
			@Param("id_eleccion_org") int id_eleccion_org,
			@Param("id_tipo_elector") int id_tipo_elector
			);

	@Select("SELECT per.id_persona, " +
			"		per.nombre, " +
			"		per.dip, " +
			"		oe.mesa, " +
			"		j.id_jurado, " +
			"		j.id_tipo_elector, " +
			"		oe.id_eleccion_org, " +
			"		CASE WHEN j.id_tipo_elector = 1 THEN 'DOCENTE' WHEN j.id_tipo_elector = 2 THEN 'ESTUDIANTE' ELSE '' END AS tipoElector, " +
			"		s.id_sede, " +
			"		s.sede, " +
			"		r.id_recinto, " +
			"		r.recinto, " +
			"		d.titulo," +
			" 		oe.id_eleccion, " +
			" 		hs.horario " +
			"	FROM teu.elecciones_organizaciones oe " +
			"		JOIN teu.jurados j on (oe.id_eleccion_org = j.id_eleccion_org) " +
			"		JOIN personas per on (per.id_persona = j.id_persona)  " +
			"		JOIN public.sedes s on (s.id_sede = oe.id_sede) " +
			"		JOIN teu.recintos r on (r.id_recinto = oe.id_recinto) " +
			"		JOIN teu.horarios_sede hs on (hs.id_sede = s.id_sede) " +
			"		LEFT JOIN public.docentes d on (d.id_persona = j.id_persona)" +
			"	WHERE j.id_estado " +
			"		AND oe.id_eleccion_org = #{ id_eleccion_org } " +
			"	ORDER BY oe.mesa, j.id_jurado " +
			";")
	public List<JuradoExtendido> getJuradoExtendidoById_eleccion_org(Integer id);

	@Select("SELECT per.id_persona, " +
			"		per.nombre, " +
			"		per.dip, " +
			"		oe.mesa, " +
			"		j.id_jurado, " +
			"		j.id_tipo_elector, " +
			"		oe.id_eleccion_org, " +
			"		CASE WHEN j.id_tipo_elector = 1 THEN 'DOCENTE' WHEN j.id_tipo_elector = 2 THEN 'ESTUDIANTE' ELSE '' END AS tipoElector, " +
			"		s.id_sede, " +
			"		s.sede, " +
			"		r.id_recinto, " +
			"		r.recinto, " +
			"		d.titulo," +
			" 		oe.id_eleccion, " +
			" 		hs.horario " +
			"	FROM teu.elecciones_organizaciones oe " +
			"		JOIN teu.jurados j on (oe.id_eleccion_org = j.id_eleccion_org) " +
			"		JOIN personas per on (per.id_persona = j.id_persona)  " +
			"		JOIN public.sedes s on (s.id_sede = oe.id_sede) " +
			"		JOIN teu.recintos r on (r.id_recinto = oe.id_recinto) " +
			"		JOIN teu.horarios_sede hs on (hs.id_sede = s.id_sede) " +
			"		LEFT JOIN public.docentes d on (d.id_persona = j.id_persona)" +
			"	WHERE j.id_estado " +
			"		AND j.id_jurado = #{ id_jurado } " +
			"	ORDER BY oe.mesa, j.id_jurado " +
			";")
	public JuradoExtendido getJuradoExtendidoById_jurado(Integer id);

	@Select("SELECT per.id_persona, per.nombre, per.dip, oe.mesa, j.id_jurado, j.id_tipo_elector , oe.id_eleccion_org, CASE WHEN j.id_tipo_elector = 1 THEN 'DOCENTE' WHEN j.id_tipo_elector = 2 THEN 'ESTUDIANTE' ELSE '' END AS tipoElector , s.id_sede, s.sede, r.id_recinto, r.recinto, d.titulo ,hs.horario " +
			"	FROM teu.elecciones_organizaciones oe " +
			"		JOIN teu.jurados j USING (id_eleccion_org) " +
			"		JOIN personas per USING (id_persona) " +
			"		JOIN public.sedes s USING (id_sede)" +
			"		JOIN teu.recintos r on (r.id_recinto = oe.id_recinto) " +
			"		JOIN teu.horarios_sede hs on (hs.id_sede = s.id_sede) " +
			"		LEFT JOIN public.docentes d on (d.id_persona = j.id_persona)" +
			"	WHERE j.id_estado " +
			"		AND oe.id_eleccion = #{ id } " +
			"	ORDER BY j.id_jurado " +
			";")
	public List<JuradoExtendido> getJuradoExtendidoById_eleccion(Integer id);

	@Select("SELECT per.id_persona, per.nombre, per.dip, oe.mesa, j.id_jurado, j.id_tipo_elector , oe.id_eleccion_org, CASE WHEN j.id_tipo_elector = 1 THEN 'DOCENTE' WHEN j.id_tipo_elector = 2 THEN 'ESTUDIANTE' ELSE '' END AS tipoElector , s.id_sede, s.sede, r.id_recinto, r.recinto, coalesce(d.titulo, 'Univ.') as titulo ,hs.horario " +
			"	FROM teu.elecciones_organizaciones oe " +
			"		JOIN teu.jurados j USING (id_eleccion_org) " +
			"		JOIN personas per USING (id_persona) " +
			"		JOIN public.sedes s USING (id_sede)" +
			"		JOIN teu.recintos r on (r.id_recinto = oe.id_recinto) " +
			"		JOIN teu.horarios_sede hs on (hs.id_sede = s.id_sede) " +
			"		LEFT JOIN public.docentes d on (d.id_persona = j.id_persona)" +
			"	WHERE j.id_estado " +
			"		AND oe.id_eleccion = #{ id } " +
			"	ORDER BY oe.mesa, j.id_tipo_elector, per.nombre" +
			";")
	public List<JuradoExtendido> getJuradoExtendidoById_eleccionOrderByNombre(Integer id);

	@Select("SELECT " +
			"	e.id_persona,  p.nombre, p.dip, eo.mesa, eo.id_sede, s.sede, eo.id_tipo_elector, " +
			"	te.tipo_elector , f.facultad, el.eleccion " +
			"FROM teu.electores e " +
			"	JOIN personas p USING (id_persona) " +
			"	JOIN teu.elecciones_organizaciones eo USING (id_eleccion_org) " +
			"	JOIN teu.elecciones el USING (id_eleccion) " +
			"	JOIN sedes s USING (id_sede) " +
			"	JOIN teu.tipos_electores te USING (id_tipo_elector) " +
			"	JOIN facultades f USING (id_facultad) " +
			"WHERE " +
			"	e.id_estado and " +
			"	e.id_eleccion_org = #{ id_eleccion_org } and " +
			"	eo.id_tipo_elector = #{ id_tipo_elector } and " +
			"	date_part('year', age(p.fec_nacimiento)) < #{ edad } and " +
			"	p.vivo and  " +
			"	p.id_persona not in ( " +
			"		select distinct (j.id_persona) " +
			"			from teu.jurados j " +
			"				join teu.elecciones_organizaciones eo on (j.id_eleccion_org = eo.id_eleccion_org) " +
			"				join teu.elecciones e on (eo.id_eleccion = e.id_eleccion) " +
			"			where " +
			"				e.fec_eleccion = ( " +
			"					select e.fec_eleccion " +
			"						from teu.elecciones e " +
			"							join teu.elecciones_organizaciones eo on (e.id_eleccion = eo.id_eleccion) " +
			"						where eo.id_eleccion_org = #{ id_eleccion_org } " +
			"			) " +
			"		union " +
			"		select " +
			"			distinct(je.id_persona) " +
			"		from " +
			"			teu.jurados_excluidos je " +
			"			join teu.elecciones e on (je.id_eleccion = e.id_eleccion) " +
			"			join teu.elecciones_organizaciones eo on (e.id_eleccion = eo.id_eleccion) " +
			"		where " +
			"			e.fec_eleccion = ( " +
			"					select e.fec_eleccion " +
			"						from teu.elecciones e " +
			"							join teu.elecciones_organizaciones eo on (e.id_eleccion = eo.id_eleccion) " +
			"						where eo.id_eleccion_org = #{ id_eleccion_org } " +
			"			) " +
			"		union " +
			"		select  " +
			"			distinct(c.id_persona)  " +
			"		from  " +
			"			teu.candidatos c " +
			"			join teu.frentes f2 on (f2.id_frente = c.id_frente) " +
			"			join teu.elecciones e on (f2.id_eleccion = e.id_eleccion)  " +
			"			left join teu.elecciones_organizaciones eo on (e.id_eleccion = eo.id_eleccion)  " +
			"		where " +
			"			e.fec_eleccion = ( " +
			"					select e.fec_eleccion " +
			"						from teu.elecciones e " +
			"							join teu.elecciones_organizaciones eo on (e.id_eleccion = eo.id_eleccion) " +
			"						where eo.id_eleccion_org = #{ id_eleccion_org } " +
			"			) " +
			"	) " +
			"ORDER BY e.id_eleccion_org, p.nombre " +
			";")
	public List<JuradoExtendido> getElectoresOrganizacionByIdEleccionOrgAndIdTipoElectorAndEdadMaxima(
				@Param("id_eleccion_org") int id_eleccion_org,
				@Param("id_tipo_elector") int id_tipo_elector,
				@Param("edad") int edad
			);

	@Select("SELECT " +
			"	e.id_persona,  p.nombre, p.dip, eo.mesa, eo.id_sede, s.sede, eo.id_tipo_elector, " +
			"	te.tipo_elector , f.facultad, el.eleccion " +
			"FROM teu.electores e " +
			"	JOIN personas p USING (id_persona) " +
			"	JOIN teu.elecciones_organizaciones eo USING (id_eleccion_org) " +
			"	JOIN teu.elecciones el USING (id_eleccion) " +
			"	JOIN sedes s USING (id_sede) " +
			"	JOIN teu.tipos_electores te USING (id_tipo_elector) " +
			"	JOIN facultades f USING (id_facultad) " +
			"WHERE " +
			"	e.id_estado and " +
			"	el.id_eleccion = #{ id_eleccion } and " +
			"	eo.id_tipo_elector = #{ id_tipo_elector } and " +
			"	date_part('year', age(p.fec_nacimiento)) < #{ edad } and " +
			"	p.vivo and  " +
			"	p.id_persona not in ( " +
			"		select distinct (j.id_persona) " +
			"			from teu.jurados j " +
			"				join teu.elecciones_organizaciones eo on (j.id_eleccion_org = eo.id_eleccion_org) " +
			"				join teu.elecciones e on (eo.id_eleccion = e.id_eleccion) " +
			"			where " +
			"				e.fec_eleccion = (select el.fec_eleccion " +
			"							from teu.elecciones el " +
			"							where el.id_eleccion = #{ id_eleccion })" +
			"		union " +
			"		select " +
			"			distinct(je.id_persona) " +
			"		from " +
			"			teu.jurados_excluidos je " +
			"			join teu.elecciones e on (je.id_eleccion = e.id_eleccion) " +
			"		where " +
			"			e.fec_eleccion = (select el.fec_eleccion " +
			"							from teu.elecciones el " +
			"							where el.id_eleccion = #{ id_eleccion }) " +
			"		union " +
			"		select  " +
			"			distinct(c.id_persona)  " +
			"		from  " +
			"			teu.candidatos c " +
			"			join teu.frentes f2 on (f2.id_frente = c.id_frente) " +
			"			join teu.elecciones e on (f2.id_eleccion = e.id_eleccion)  " +
			"		where " +
			"			e.fec_eleccion = (select el.fec_eleccion " +
			"							from teu.elecciones el " +
			"							where el.id_eleccion = #{ id_eleccion })" +
			"	) " +
			"ORDER BY e.id_eleccion_org, p.nombre " +
			";")
	public List<JuradoExtendido> getElectoresOrganizacionByIdEleccionAndIdTipoElectorAndEdadMaxima(
			@Param("id_eleccion") int id_eleccion,
			@Param("id_tipo_elector") int id_tipo_elector,
			@Param("edad") int edad
		);

	@Select("SELECT  min(j.id_jurado) " +
			"	FROM teu.elecciones_organizaciones oe " +
			"		JOIN teu.jurados j USING (id_eleccion_org) " +
			"		JOIN personas per USING (id_persona)  " +
			"		JOIN public.sedes s USING (id_sede) " +
			"	WHERE j.id_estado " +
			"		AND oe.id_eleccion = #{ id_eleccion } " +
			";")
	public Integer getMinId_juradoById_eleccion(Integer id_eleccion);

	@Select("select e.eleccion,e.fec_eleccion,eo.mesa,r.recinto,r.ubicacion,t.tipo_elector " +
			"	from public.personas p  " +
			"		inner join teu.electores v using(id_persona) " +
			"		inner join teu.elecciones_organizaciones eo using(id_eleccion_org) " +
			"		inner join teu.elecciones e using(id_eleccion) " +
			"		inner join teu.recintos r using(id_recinto) " +
			"		inner join teu.tipos_electores t using(id_tipo_elector) " +
			"	where " +
			"		v.id_estado " +
			"		and p.id_persona = #{ id_persona } " +
			"		and e.id_estado " +
			"		and	e.fec_eleccion >= CURRENT_DATE " +
			";")
	public List<VerificarEleccion> verificarElectorById_persona(Integer id_persona);

	@Select("select j.id_jurado,eo.mesa,t.tipo_elector, e.eleccion, e.id_eleccion, e.fec_eleccion , s.sede , r.recinto, r.ubicacion " +
			"	from public.personas p			 " +
			"		left join teu.jurados j on(p.id_persona = j.id_persona) " +
			"		join teu.elecciones_organizaciones eo on (eo.id_eleccion_org = j.id_eleccion_org) " +
			"		join teu.tipos_electores t on (t.id_tipo_elector =eo.id_tipo_elector) " +
			"		join teu.recintos r on (eo.id_recinto = r.id_recinto) " +
			"		join public.sedes s on (s.id_sede = eo.id_sede) " +
			"		join teu.elecciones e using(id_eleccion) " +
			"	where " +
			"		e.id_estado " +
			"		and e.fec_eleccion >= CURRENT_DATE " +
			"		and p.id_persona = #{ id_persona } " +
			"	and j.id_estado " +
			";")
	public List<VerificarEleccion> verificarJuradoById_persona(Integer id_persona);
}