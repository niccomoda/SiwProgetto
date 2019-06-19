package it.uniroma3.BiagioniModanese.SilphSPA.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.BiagioniModanese.SilphSPA.Model.Carrello;
import it.uniroma3.BiagioniModanese.SilphSPA.Model.Foto;
import it.uniroma3.BiagioniModanese.SilphSPA.Service.FotoService;

@Controller
public class CarrelloController {
	
	
	@Autowired
	private FotoService fotoService;
	
	
	@RequestMapping(value = "/mostraCarrello")
	public String mostraCarrello(Model model) {
		model.addAttribute("carrello", Carrello.getCarrello());
		return "Carrello.html";
	}
	
	@RequestMapping(value = "/fotoCarrello/{id}", method = RequestMethod.GET)
	public String fotoCarrello(@PathVariable("id") Long id, Model model) {
		Carrello c = Carrello.getCarrello();
		Foto f = this.fotoService.trovaFotoPerId(id);
		Set<Foto> foto = c.getFoto();
		foto.add(f);
		model.addAttribute("carrello", c);
		return "Carrello.html";
	}
	
	@RequestMapping(value="/eliminaFoto/{id}")
	public String eliminaFoto(@PathVariable("id") Long id, Model model) {
		Carrello c = Carrello.getCarrello();
		Foto f = this.fotoService.trovaFotoPerId(id);
		System.out.println(f.getNome());
		c.rimuoviFoto(f);
		model.addAttribute("carrello", c);
		return "Carrello.html";
	}
	
	
	
}
