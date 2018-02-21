package com.niit.backend.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.niit.backend.dto.User;

public class PasswordValidator implements Validator{

	@Override
	public boolean supports(Class<?> classObj) {
		return User.class.isAssignableFrom(classObj);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required.password", "Field name is required.");

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password2",
					"required.confirmPassword", "Field name is required.");

			User user = (User)target;

			if(!(user.getPassword().equals(user.getPassword2()))){
				errors.rejectValue("password", "notmatch.password");
			}

		}
		
	

}
