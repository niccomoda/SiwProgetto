package it.uniroma3.BiagioniModanese.SilphSPA.Service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.BiagioniModanese.SilphSPA.Model.Staff;
import it.uniroma3.BiagioniModanese.SilphSPA.Repository.StaffRepository;

@Service
public class StaffService {

	@Autowired
	private StaffRepository staffRepository;
	
	@Transactional
	public Staff login(String username, String password) {
		return staffRepository.findByUsernameAndPassword(username, password);
		
	}
	
	@Transactional 
	public Staff inserisci(Staff staff) {
		return staffRepository.save(staff);
	}
	
}
