package it.uniroma3.BiagioniModanese.SilphSPA.Service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.BiagioniModanese.SilphSPA.Model.AlbumForm;

@Component
public class AlbumFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return AlbumForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idFotografo", "required");
		
	}

}
