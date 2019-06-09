package it.uniroma3.BiagioniModanese.SilphSPA.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	@ManyToOne
	private Fotografo fotografo;
	
	@ManyToMany
	private List<Foto> foto;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Fotografo getFotografo() {
		return fotografo;
	}

	public void setFotografo(Fotografo fotografo) {
		this.fotografo = fotografo;
	}

	public List<Foto> getFoto() {
		return foto;
	}

	public void setFoto(List<Foto> foto) {
		this.foto = foto;
	}

	public Long getId() {
		return id;
	}
	
	
	

}