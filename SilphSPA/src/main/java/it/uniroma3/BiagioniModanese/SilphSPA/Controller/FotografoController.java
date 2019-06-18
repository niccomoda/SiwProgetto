package it.uniroma3.BiagioniModanese.SilphSPA.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.BiagioniModanese.SilphSPA.Model.Fotografo;
import it.uniroma3.BiagioniModanese.SilphSPA.Model.StringaRicerca;
import it.uniroma3.BiagioniModanese.SilphSPA.Service.FotografoService;
import it.uniroma3.BiagioniModanese.SilphSPA.Service.FotografoValidator;

@Controller
public class FotografoController {
	
	@Autowired
	private FotografoService fotografoService;
	
	@Autowired
	private FotografoValidator fotografoValidator;
	
	
	@RequestMapping(value = "/inserisciFotografo", method = RequestMethod.POST)
	public String newFotografo(@Valid @ModelAttribute("fotografo") Fotografo fotografo, Model model, BindingResult bindingResult) {
		//this.fotografoValidator.validate(fotografo, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.fotografoService.salvaFotografo(fotografo);
			return "fotografo.html";
		}
		else {
			return "inserimentoFotografo.html";
		}
	}
	
	@RequestMapping(value = "/ricercaFotografo")
	public String ricercaFotografo() {
		return "ricercafotografo.html";
	}
	
	@RequestMapping(value = "/fotografoNomeCognome")
	public String cercaFotografoNomeCognome(Model model) {
		model.addAttribute("stringaRicerca", new StringaRicerca());
		return "ricercaFotografoNomeCognome.html";
	}
	
	@RequestMapping(value = "/fotografoPerId")
	public String cercaFotografoPerId(Model model) {
		model.addAttribute("stringaRicerca", new StringaRicerca());
		return "ricercaFotografoPerId.html";
	}
	
	@RequestMapping(value = "/risultatiFotografoNomeCognome", method = RequestMethod.POST)
	public String risultatiFotografoNomeCognome(@ModelAttribute("stringaRicerca") StringaRicerca s, Model model, BindingResult bindingResult) {
		List<Fotografo> risultato;
		if(s.getS1() == "" && s.getS2() == "") {
			bindingResult.rejectValue("s1", "wrong");
			return "ricercaFotografoNomeCognome.html";
		}
		else if(s.getS1() == "") {
			risultato = this.fotografoService.trovaFotografoPerCognome(s.getS2());
		}
		else if(s.getS2() == "") {
			risultato = this.fotografoService.trovaFotografoPerCognome(s.getS1());
		}
		else {
			risultato = this.fotografoService.trovaFotografoPerNomeCognome(s.getS1(), s.getS2());
		}
		if(risultato.size() == 0) {
			bindingResult.rejectValue("s1", "wrong");
			return "ricercaFotografoNomeCognome.html";
		}
		else {
			model.addAttribute("risultato", risultato);
			return "listaFotografi.html";
		}
	}
	
	
	
	
	
	
	

}
