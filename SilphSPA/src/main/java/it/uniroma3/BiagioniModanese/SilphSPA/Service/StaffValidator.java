package it.uniroma3.BiagioniModanese.SilphSPA.Service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.BiagioniModanese.SilphSPA.Model.Staff;

@Component
public class StaffValidator implements Validator {
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"Username", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Password", "required");
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Staff.class.equals(clazz);
	}
}
