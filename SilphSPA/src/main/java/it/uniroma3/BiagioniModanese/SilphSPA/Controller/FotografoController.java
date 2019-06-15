package it.uniroma3.BiagioniModanese.SilphSPA.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.BiagioniModanese.SilphSPA.Model.Fotografo;
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
		this.fotografoValidator.validate(fotografo, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.fotografoService.salvaFotografo(fotografo);
			return "successo.html";
		}
		else {
			return "inserimentoFotografo.html";
		}
	}
	
	

}
