package it.uniroma3.BiagioniModanese.SilphSPA.Controller;

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
	
	@RequestMapping(value = "/addAlbum")
	public String addAlbum(Model model) {
		model.addAttribute("albumForm", new AlbumForm());
		return "inserimentoAlbum.html";
	}
	
	@RequestMapping(value = "/inserisciAlbum", method = RequestMethod.POST)
	public String newAlbum(@Valid @ModelAttribute("albumForm") AlbumForm albumForm, Model model, BindingResult bindingResult) {
		this.albumFormValidator.validate(albumForm, bindingResult);
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
	
}
