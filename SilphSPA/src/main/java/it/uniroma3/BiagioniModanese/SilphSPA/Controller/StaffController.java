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
import it.uniroma3.BiagioniModanese.SilphSPA.Model.Fotografo;
import it.uniroma3.BiagioniModanese.SilphSPA.Model.Staff;
import it.uniroma3.BiagioniModanese.SilphSPA.Service.StaffService;
import it.uniroma3.BiagioniModanese.SilphSPA.Service.StaffValidator;

@Controller
public class StaffController {
	
	@Autowired
	private StaffValidator staffValidator;
	
	@Autowired
	private StaffService staffService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("staff") Staff staff, Model model, BindingResult bindingResult) {
		this.staffValidator.validate(staff, bindingResult);
		if(!bindingResult.hasErrors()) {
			Staff c = staffService.login(staff.getUser(), staff.getPassword());
			if(c == null) {
				bindingResult.rejectValue("username", "wrong");
				return "login.html";
			}
			else {
				return "successo.html";
			}
		
		}
		else {
			return "login.html";
		}
	}
	
	@RequestMapping(value = "/loginForm")
	public String loginForm(Model model) {
		model.addAttribute("staff", new Staff());
		return "login.html";
	}
	
	@RequestMapping(value = "/inserimentoFoto")
	public String inserimentoFoto(Model model) {
		model.addAttribute("foto", new Foto());
		return "inserimentoFoto.html";
	}
	
	@RequestMapping(value = "/inserimenteFotografo")
	public String inserimentoFotografo(Model model) {
		model.addAttribute("fotografo", new Fotografo());
		return "inserimentoFotografo.html";
	}
	
	
	
}
