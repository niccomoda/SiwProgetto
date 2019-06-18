 package it.uniroma3.BiagioniModanese.SilphSPA.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.BiagioniModanese.SilphSPA.Model.AlbumForm;
import it.uniroma3.BiagioniModanese.SilphSPA.Model.FotoForm;
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
	/*
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("staff") Staff staff, Model model, BindingResult bindingResult) {
		this.staffValidator.validate(staff, bindingResult);
		if(!bindingResult.hasErrors()) {
			Staff c = staffService.login(staff.getUsername(), staff.getPassword());
			if(c == null) {
				bindingResult.rejectValue("username", "wrong");
				return "login.html";
			}
			else {
				return "admin.html";
			}
		
		}
		else {
			return "admin.html";
		}
	}*/
/*
	@RequestMapping(value = "/loginForm")
	public String loginForm(Model model) {
		model.addAttribute("staff", new Staff());
		return "login.html";
	}
	*/
	@RequestMapping(value = "/admin")
	public String loginSuccess(Model model) {
		return "admin.html";
	}
		@RequestMapping(value = "/login", method = RequestMethod.GET )
	public String loginView(Model model) {

		Staff ss = new Staff();
		ss.setUsername("admin");
		ss.setRole("admin");
		ss.setPassword(new BCryptPasswordEncoder().encode("admin"));
		this.staffService.inserisci(ss);
		return "login.html";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET )
	public String logout(Model model) {
		return "logout.html";
	}

	
	
	@RequestMapping(value = "/inserimentoFoto")
	public String inserimentoFoto(Model model) {
		model.addAttribute("fotoForm", new FotoForm());
		return "inserimentoFoto.html";
	}
	
	@RequestMapping(value = "/inserimentoFotografo")
	public String inserimentoFotografo(Model model) {
		model.addAttribute("fotografo", new Fotografo());
		return "inserimentoFotografo.html";
	}
	
	@RequestMapping(value = "/inserimentoAlbum")
	public String inserimentoAlbum(Model model) {
		model.addAttribute("albumForm", new AlbumForm());
		return "inserimentoAlbum.html";
	}
	
	@RequestMapping(value = "/inserimento", method = RequestMethod.GET)
	public String inserimento(Model model) {
		return "inserimento.html";
	}
	
	@RequestMapping(value = "/consulta")
	public String ricerca() {
		return "ricerca.html";
	}
	

	
	
}
