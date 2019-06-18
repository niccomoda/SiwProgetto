package it.uniroma3.BiagioniModanese.SilphSPA.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.BiagioniModanese.SilphSPA.Model.Album;
import it.uniroma3.BiagioniModanese.SilphSPA.Model.Fotografo;

public interface AlbumRepository extends CrudRepository<Album, Long>{
	public List<Album> findByNome(String nome);
	public List<Album> findByFotografo(Fotografo fotografo);
}