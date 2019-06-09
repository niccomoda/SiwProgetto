package it.uniroma3.BiagioniModanese.SilphSPA.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.BiagioniModanese.SilphSPA.Model.Album;

public interface AlbumRepository extends CrudRepository<Album, Long>{
	public List<Album> findByNome(String nome);
}