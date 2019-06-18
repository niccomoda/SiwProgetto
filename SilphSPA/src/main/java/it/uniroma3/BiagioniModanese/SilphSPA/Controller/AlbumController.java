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

import it.uniroma3.BiagioniModanese.SilphSPA.Model.Album;
import it.uniroma3.BiagioniModanese.SilphSPA.Model.AlbumForm;
import it.uniroma3.BiagioniModanese.SilphSPA.Model.Fotografo;
import it.uniroma3.BiagioniModanese.SilphSPA.Model.StringaRicerca;
import it.uniroma3.BiagioniModanese.SilphSPA.Service.AlbumFormValidator;
import it.uniroma3.BiagioniModanese.SilphSPA.Service.AlbumService;
import it.uniroma3.BiagioniModanese.SilphSPA.Service.FotografoService;

@Controller
public class AlbumController {

	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private FotografoService fotografoService;
	
	@Autowired
	private AlbumFormValidator albumFormValidator;
	
	
	@RequestMapping(value = "/inserisciAlbum", method = RequestMethod.POST)
	public String newAlbum(@Valid @ModelAttribute("albumForm") AlbumForm albumForm, Model model, BindingResult bindingResult) {
		//this.albumFormValidator.validate(albumForm, bindingResult);
		if(!bindingResult.hasErrors()) {
			Long id = null;
			try{id = Long.parseLong(albumForm.getIdFotografo());}
			catch(NumberFormatException e) {
				bindingResult.rejectValue("idFotografo", "wrong");
			}
			Fotografo fotografo = this.fotografoService.trovaFotografoPerId(id);
			if(fotografo != null) {
				Album album = new Album();
				album.setNome(albumForm.getNome());
				album.setFotografo(fotografo);
				albumService.salvaAlbum(album);
				fotografo.getAlbum().add(album);
				return "album.html";
			}
			else {
				bindingResult.rejectValue("idFotografo", "wrong");
				return "inserimentoAlbum.html";
			}
		}
		return "inserimentoAlbum.html";
	}
	
	@RequestMapping(value = "/ricercaAlbum")
	public String ricercaAlbum() {
		return "ricercaAlbum.html";
	}
	
	@RequestMapping(value = "/AlbumNome")
	public String cercaAlbumNome(Model model) {
		model.addAttribute("stringaRicerca", new StringaRicerca());
		return "ricercaAlbumNome.html";
	}
	
	@RequestMapping(value = "/AlbumPerId")
	public String cercaAlbumPerId(Model model) {
		model.addAttribute("stringaRicerca", new StringaRicerca());
		return "ricercaAlbumPerId.html";
	}
	
	@RequestMapping(value = "/risultatiAlbumNome", method = RequestMethod.POST)
	public String risultatiAlbumNome(@ModelAttribute("stringaRicerca") StringaRicerca s, Model model, BindingResult bindingResult) {
		List<Album> risultato;
		if(s.getS1() == "") {
			bindingResult.rejectValue("s1", "wrong");
			return "ricercaAlbumNome.html";
		}
		risultato = this.albumService.trovaAlbumPerNome(s.getS1());
		if(risultato.size() == 0) {
			bindingResult.rejectValue("s1", "wrong");
			return "ricercaAlbumNome.html";
		}
		else {
			model.addAttribute("risultato", risultato);
			return "listaAlbum.html";
		}
	}

	@RequestMapping(value ="/cercaAlbumPerId")
	public String risultatoAlbumId(@ModelAttribute("stringaRicerca") StringaRicerca s, Model model, BindingResult bindingResult) {
		if(s.getS1() == "") {
			bindingResult.rejectValue("s1", "wrong");
			return "ricercaAlbumId.html";
		}
		Album a = this.albumService.trovaAlbumPerId(Long.parseLong(s.getS1()));
		if(a != null) {
			model.addAttribute("album", a);
			return "risultatoAlbumPerId.html";
		}
		else
			return "ricercaAlbumId.html";
	}
}
