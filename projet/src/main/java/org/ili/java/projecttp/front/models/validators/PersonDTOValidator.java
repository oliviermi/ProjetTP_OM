package org.ili.java.projecttp.front.models.validators;

import org.ili.java.projecttp.front.models.dto.PersonDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 * @author Olivier MICHALSKI
 *
 */
@Component
public class PersonDTOValidator implements Validator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(final Class<?> clazz) {
		return PersonDTO.class.isAssignableFrom(clazz);
	}

	
	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(final Object target, final Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required.userName", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "required.address", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required.confirmPassword",
				"Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "required.sex", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "favNumber", "required.favNumber", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "javaSkills", "required.javaSkills",
				"Field name is required.");
		
		final PersonDTO personDTO = (PersonDTO) target;

//		if (!(personDTO.getPassword().equals(personDTO.getConfirmPassword()))) {
//			errors.rejectValue("password", "notmatch.password");
//		}
//
//		if (personDTO.getFavFramework().length == 0) {
//			errors.rejectValue("favFramework", "required.favFrameworks");
//		}
//
//		if ("NONE".equals(personDTO.getCountry())) {
//			errors.rejectValue("country", "required.country");
//		}

	}

}