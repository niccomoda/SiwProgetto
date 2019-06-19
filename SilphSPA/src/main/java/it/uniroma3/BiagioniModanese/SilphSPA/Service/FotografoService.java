package it.uniroma3.BiagioniModanese.SilphSPA.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.BiagioniModanese.SilphSPA.Model.Fotografo;
import it.uniroma3.BiagioniModanese.SilphSPA.Repository.FotografoRepository;

@Service
public class FotografoService {
	
	@Autowired
	private FotografoRepository fotografoRepository;
	
	@Transactional
	public Fotografo salvaFotografo(Fotografo fotografo) {
		return fotografoRepository.save(fotografo);
	}
	
	@Transactional
	public Fotografo trovaFotografoPerId(Long id) {
		try {
			return this.fotografoRepository.findById(id).get();
		}catch(NoSuchElementException e) {
			return null;
		}
	}
	
	@Transactional
	public List<Fotografo> trovaFotografoPerNome(String nome){
			return this.fotografoRepository.findByNome(nome);
	}
	
	@Transactional
	public List<Fotografo> trovaFotografoPerCognome(String cognome){
			return this.fotografoRepository.findByCognome(cognome);
	}
	
	@Transactional
	public List<Fotografo> trovaFotografoPerNomeCognome(String nome, String cognome){
			return this.fotografoRepository.findByNomeAndCognome(nome, cognome);
	}
	
	@Transactional
	public List<Fotografo> tuttiFotografi(){
		return (List<Fotografo>)this.fotografoRepository.findAll();
	}

	
}
