package it.uniroma3.BiagioniModanese.SilphSPA.Repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.BiagioniModanese.SilphSPA.Model.Staff;

@Repository
public interface StaffRepository extends CrudRepository<Staff, String>{
		
	public Staff findByUsernameAndPassword(String username, String password);
}
