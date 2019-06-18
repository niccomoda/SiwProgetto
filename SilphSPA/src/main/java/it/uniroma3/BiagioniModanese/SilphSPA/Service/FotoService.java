package it.uniroma3.BiagioniModanese.SilphSPA.Service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.BiagioniModanese.SilphSPA.Model.Foto;
import it.uniroma3.BiagioniModanese.SilphSPA.Repository.FotoRepository;

@Service
public class FotoService {

	@Autowired
	private FotoRepository fotoRepository;
	
	@Transactional
	public Foto inserisci(Foto foto) {
		return fotoRepository.save(foto);
	}
	
	
	
	
	
}
