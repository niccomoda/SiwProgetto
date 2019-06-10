package it.uniroma3.BiagioniModanese.SilphSPA.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.vaadin.flow.component.polymertemplate.Id;

@Entity
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	
	public Staff() {
		
	}
	
	public String getUser() {
		return username;
	}
	public void setUser(String user) {
		this.username = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
