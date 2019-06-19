package it.uniroma3.BiagioniModanese.SilphSPA.Model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public final class Carrello{
	private static Carrello carrello;
	private Set<Foto> foto;
	
	private Carrello() {
		this.foto = new HashSet<Foto>();
	}
	
	@Bean
	@Scope("singleton")
	public static Carrello getCarrello() {
		if(carrello == null) {
			carrello = new Carrello();
		}
		return carrello;
	}

	public Set<Foto> getFoto() {
		return foto;
	}

	public void setFoto(Set<Foto> foto) {
		this.foto = foto;
	}
	
	public void aggiungiFoto(Foto foto) {
		carrello.getFoto().add(foto);
	}
	
	public void rimuoviFoto(Foto foto) {
		carrello.getFoto().remove(foto);
	}
	
	public void svuotaCarrello() {
		carrello.getFoto().clear();
	}
	
	
}