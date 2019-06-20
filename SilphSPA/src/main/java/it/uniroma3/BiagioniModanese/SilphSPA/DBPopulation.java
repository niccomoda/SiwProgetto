package it.uniroma3.BiagioniModanese.SilphSPA;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import it.uniroma3.BiagioniModanese.SilphSPA.Model.Album;
import it.uniroma3.BiagioniModanese.SilphSPA.Model.Foto;
import it.uniroma3.BiagioniModanese.SilphSPA.Model.Fotografo;
import it.uniroma3.BiagioniModanese.SilphSPA.Model.Staff;
import it.uniroma3.BiagioniModanese.SilphSPA.Service.AlbumService;
import it.uniroma3.BiagioniModanese.SilphSPA.Service.FotoService;
import it.uniroma3.BiagioniModanese.SilphSPA.Service.FotografoService;
import it.uniroma3.BiagioniModanese.SilphSPA.Service.StaffService;

@Component
public class DBPopulation implements ApplicationRunner{

	@Autowired
	private StaffService staffService;
	
	@Autowired
	private FotografoService fotografoService;
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private FotoService fotoService;
	
	public void run(ApplicationArguments args) throws Exception {
		this.populatedDB();
		
	}
	
	
	private void populatedDB() throws IOException, InterruptedException {
	System.out.println(staffService.tuttiGliStaff().toString());
	System.out.println(fotografoService.tuttiFotografi().toString());
	System.out.println(albumService.mostraTuttiAlbum().toString());
	System.out.println(fotoService.tutteLeFoto().toString());
		if(staffService.tuttiGliStaff().isEmpty()) {
		Staff staff = new Staff("admin", "admin", "admin");
		String adminPassword = new BCryptPasswordEncoder().encode("admin");
		staff.setPassword(adminPassword);
		this.staffService.inserisci(staff);
		}
		
		if(fotografoService.tuttiFotografi().isEmpty()) {
			Fotografo f1 = new Fotografo("Niccolò", "Modanese", "https://bit.ly/2FmOB97");
			Fotografo f2 = new Fotografo("Mario", "Rossi", "https://bit.ly/2L3F7Dh");
			Fotografo f3 = new Fotografo("Pino", "Daniele", "https://bit.ly/31LH1OI");
			Fotografo f4 = new Fotografo("Daniele", "Spacca", "https://bit.ly/2XZIT4g");
			this.fotografoService.salvaFotografo(f1);
			this.fotografoService.salvaFotografo(f2);
			this.fotografoService.salvaFotografo(f3);
			this.fotografoService.salvaFotografo(f4);
			
			if(albumService.mostraTuttiAlbum().isEmpty()) {
				Album a1 = new Album("Macchine Sportive", f1);
				Album a2 = new Album("Sport", f2);
				Album a3 = new Album("Musica", f3);
				Album a4 = new Album("Pizza", f4);
				Album a5 = new Album("Natura", f1);
				this.albumService.salvaAlbum(a1);
				this.albumService.salvaAlbum(a2);
				this.albumService.salvaAlbum(a3);
				this.albumService.salvaAlbum(a4);
				this.albumService.salvaAlbum(a5);
				
				if(fotoService.tutteLeFoto().isEmpty()) {
					Foto ft1 = new Foto("Ferrari Rossa", "https://bit.ly/2WStJRP", a1, f1);
					Foto ft2 = new Foto("Lamborghini Blu", "https://bit.ly/2FmIelZ", a1, f1);
					Foto ft3 = new Foto("Mustang", "https://bit.ly/2Kwk0Km", a1, f1);
					Foto ft4 = new Foto("Cervo", "https://bit.ly/2XnGV0C", a5, f1);
					Foto ft5 = new Foto("Pizza Margherita", "https://bit.ly/2xfd0ZT", a4, f4);
					Foto ft6 = new Foto("Pizza Diavola", "https://bzfd.it/2Vg4AQb", a4, f4);
					Foto ft7 = new Foto("Tennis", "https://bit.ly/2MYFRfG", a2, f2);
					Foto ft8 = new Foto("Hip Hop", "https://bit.ly/2IsBZPG", a2, f2);
					Foto ft9 = new Foto("Musica", "https://bit.ly/2WTyzyn", a3, f3);
					Foto ft10 = new Foto("Natura", "https://bit.ly/2L5qLlN", a5, f1);
					this.fotoService.inserisci(ft1);
					this.fotoService.inserisci(ft2);
					this.fotoService.inserisci(ft3);
					this.fotoService.inserisci(ft4);
					this.fotoService.inserisci(ft5);
					this.fotoService.inserisci(ft6);
					this.fotoService.inserisci(ft7);
					this.fotoService.inserisci(ft8);
					this.fotoService.inserisci(ft9);
					this.fotoService.inserisci(ft10);
					
				}
				
			}
			
		}
	}

}
