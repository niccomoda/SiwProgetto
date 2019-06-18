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
import it.uniroma3.BiagioniModanese.SilphSPA.Model.Foto;
import it.uniroma3.BiagioniModanese.SilphSPA.Model.FotoForm;
import it.uniroma3.BiagioniModanese.SilphSPA.Model.Fotografo;
import it.uniroma3.BiagioniModanese.SilphSPA.Model.StringaRicerca;
import it.uniroma3.BiagioniModanese.SilphSPA.Service.FotoService;
import it.uniroma3.BiagioniModanese.SilphSPA.Service.FotografoService;
import it.uniroma3.BiagioniModanese.SilphSPA.Service.AlbumService;
import it.uniroma3.BiagioniModanese.SilphSPA.Service.FotoFormValidator;

@Controller
public class FotoController {

	@Autowired
	private FotoService fotoService;
	@Autowired
	private FotoFormValidator fotoFormValidator;
	@Autowired
	private FotografoService fotografoService;
	@Autowired
	private AlbumService albumService;
	
	//proviamo il push
	@RequestMapping(value="/inserimentoFoto", method= RequestMethod.POST)
	public String newFoto(@Valid @ModelAttribute("fotoForm") FotoForm fotoForm, Model model, BindingResult bindingResult) {
		//this.fotoFormValidator.validate(fotoForm, bindingResult);
		if(!bindingResult.hasErrors()) {
			Long id1 = null;
			Long id2 = null;
			try {
				id1 = Long.parseLong(fotoForm.getIdFotografo());
			}
			catch(NumberFormatException e) {
				bindingResult.rejectValue("idFotografo", "wrong");
			}
			try {
				id2 = Long.parseLong(fotoForm.getIdAlbum());
			}
			catch(NumberFormatException e) {
				bindingResult.rejectValue("idAlbum", "wrong");
			}
			Fotografo f = this.fotografoService.trovaFotografoPerId(id1);
			for(Album alb : this.albumService.trovaAlbumPerFotografo(f)) {
				if(alb.getId() == id2) {
					if(f != null) {
						Foto foto = new Foto();
						foto.setAlbum(alb);
						foto.setFotografo(f);
						foto.setNome(fotoForm.getNome());
						foto.setUri(fotoForm.getUri());
						alb.getFoto().add(foto);
						f.getFoto().add(foto);
						fotoService.inserisci(foto);
						return "foto.html";
					}
				}
			}
		}
		return "inserimentoFoto.html";
	}


	@RequestMapping(value = "/ricercaFoto")
	public String ricercaFoto() {
		return "ricercaFoto.html";
	}

	@RequestMapping(value = "/fotoNome")
	public String cercaFotoNome(Model model) {
		model.addAttribute("stringaRicerca", new StringaRicerca());
		return "ricercaFotoNome.html";
	}

	@RequestMapping(value = "/fotoPerId")
	public String cercaFotoPerId(Model model) {
		model.addAttribute("stringaRicerca", new StringaRicerca());
		return "ricercaFotoPerId.html";
	}
	
	@RequestMapping(value = "/addFoto")
	public String aggiungiFoto(Model model) {
		model.addAttribute("foto", new FotoForm());
		return "inserimentoFoto.html";
	}
	
	
}
