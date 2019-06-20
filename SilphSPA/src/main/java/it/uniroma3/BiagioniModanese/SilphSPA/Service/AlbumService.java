package it.uniroma3.BiagioniModanese.SilphSPA.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.BiagioniModanese.SilphSPA.Model.Album;
import it.uniroma3.BiagioniModanese.SilphSPA.Model.Fotografo;
import it.uniroma3.BiagioniModanese.SilphSPA.Repository.AlbumRepository;

@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository albumRepository;
	
	@Transactional
	public Album salvaAlbum(Album album) {
		return albumRepository.save(album);
	}
	
	
	@Transactional
	public List<Album> trovaAlbumPerNome(String nome){
			return this.albumRepository.findByNome(nome);
	}
	
	@Transactional
	public Album trovaAlbumPerId(Long id) {
		try {
			return this.albumRepository.findById(id).get();
		}catch(NoSuchElementException e) {
			return null;
		}
	}
	
	@Transactional
	public List<Album> trovaAlbumPerFotografo(Fotografo fotografo) {
			return this.albumRepository.findByFotografo(fotografo);
	}
	

	@Transactional
	public List<Album> mostraTuttiAlbum(){
		return (List<Album>)this.albumRepository.findAll();
	}
	
}
