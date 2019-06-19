package it.uniroma3.BiagioniModanese.SilphSPA.Service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.BiagioniModanese.SilphSPA.Model.Richiesta;
import it.uniroma3.BiagioniModanese.SilphSPA.Repository.RichiestaRepository;

@Service
public class RichiestaService {
	
	@Autowired
	private RichiestaRepository richiestaRepository;
	
	@Transactional 
	public Richiesta inserisci(Richiesta richiesta) {
		return richiestaRepository.save(richiesta);
	}
	
	@Transactional
	public List<Richiesta> tutteLeRichieste() {
		return (List<Richiesta>)richiestaRepository.findAll();
	}
	
	@Transactional
	public Richiesta trovaRichiestaPerId(Long id) {
		try {
			return this.richiestaRepository.findById(id).get();
		}catch(NoSuchElementException e) {
			return null;
		}
	}
}
