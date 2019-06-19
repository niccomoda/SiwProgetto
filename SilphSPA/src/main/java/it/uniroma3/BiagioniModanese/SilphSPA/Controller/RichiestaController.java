package it.uniroma3.BiagioniModanese.SilphSPA.Controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.BiagioniModanese.SilphSPA.Model.Carrello;
import it.uniroma3.BiagioniModanese.SilphSPA.Model.Foto;
import it.uniroma3.BiagioniModanese.SilphSPA.Model.Richiesta;
import it.uniroma3.BiagioniModanese.SilphSPA.Service.RichiestaService;
import it.uniroma3.BiagioniModanese.SilphSPA.Service.RichiestaValidator;

@Controller
public class RichiestaController {

	@Autowired
	private RichiestaService richiestaService;
	private RichiestaValidator richiestaValidator;
	
	@RequestMapping(value = "/inviaRichiesta")
	public String addRichiesta(Model model) {
		model.addAttribute("richiesta", new Richiesta());
		return "nuovaRichiesta.html";
	}
	
	@RequestMapping(value="/nuovaRichiesta", method=RequestMethod.POST)
	public String newRichiesta(@Valid@ModelAttribute("richiesta") Richiesta richiesta, Model model, BindingResult bindingResult) {
		//this.richiestaValidator.validate(richiesta, bindingResult);
		if(!bindingResult.hasErrors()) {
			Carrello c = Carrello.getCarrello();
			Set<Foto> foto = c.getFoto();
			richiesta.setFoto(foto);
			this.richiestaService.inserisci(richiesta);
			c.svuotaCarrello();
			model.addAttribute("richiesta",richiesta);
			return "richiesta.html";
		}
		return "nuovaRichiesta.html";
	}
	
	@RequestMapping(value="/visualizzaRichiesta")
	public String risultatoRichiesta(Model model) {
		List<Richiesta> richieste = this.richiestaService.tutteLeRichieste();
		model.addAttribute("richieste", richieste);
		return "visualizzaRichiesta.html";
	}
	
	@RequestMapping(value="/listaDifotoRichiesta/{id}")
	public String listaFotoRichiesta(@PathVariable("id") Long id, Model model) {
		Richiesta r = this.richiestaService.trovaRichiestaPerId(id);
		model.addAttribute("richiesta", r);
		return "listaFotoRichiesta.html";
		}
}
