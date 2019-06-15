package it.uniroma3.BiagioniModanese.SilphSPA.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.BiagioniModanese.SilphSPA.Model.Foto;
import it.uniroma3.BiagioniModanese.SilphSPA.Model.FotoForm;
import it.uniroma3.BiagioniModanese.SilphSPA.Repository.FotoRepository;
import it.uniroma3.BiagioniModanese.SilphSPA.Service.FotoService;
import it.uniroma3.BiagioniModanese.SilphSPA.Service.FotoFormValidator;

@Controller
public class FotoController {

	@Autowired
	private FotoService fotoService;
	@Autowired
	private FotoFormValidator fotoFormValidator;
	
	@RequestMapping("/addFoto")
	public String addFoto(Model model) {
		model.addAttribute("foto", new FotoForm());
		return "inserimentoFoto.html";
	}
	
	@RequestMapping(value="/foto", method= RequestMethod.POST)
	public String newFoto(@Valid @ModelAttribute("foto") FotoForm fotoForm, Model model, BindingResult bindingResult) {
		this.fotoValidator.validate(fotoForm, bindingResult);
		if(!bindingResult.hasErrors()) {
			
		}
	}
	
}
