package it.uniroma3.BiagioniModanese.SilphSPA.Model;

import javax.persistence.Entity;


@Entity
public class FotoForm {
	
	private String nome;
	private String idFotografo;
	private String idAlbum;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdFotografo() {
		return idFotografo;
	}

	public void setIdFotografo(String idFotografo) {
		this.idFotografo = idFotografo;
	}

	public String getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(String idAlbum) {
		this.idAlbum = idAlbum;
	}
}
