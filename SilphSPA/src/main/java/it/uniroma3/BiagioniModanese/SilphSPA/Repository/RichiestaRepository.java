package it.uniroma3.BiagioniModanese.SilphSPA.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.BiagioniModanese.SilphSPA.Model.Richiesta;

@Repository
public interface RichiestaRepository extends CrudRepository<Richiesta, Long>{

}
