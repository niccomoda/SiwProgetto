package it.uniroma3.BiagioniModanese.SilphSPA.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.BiagioniModanese.SilphSPA.Model.Fotografo;

public interface FotografoRepository extends CrudRepository<Fotografo, Long>{
	public List<Fotografo> findByNome(String nome);
	public List<Fotografo> findByCognome(String cognome);
	public List<Fotografo> findByNomeAndCognome(String nome, String cognome);
}