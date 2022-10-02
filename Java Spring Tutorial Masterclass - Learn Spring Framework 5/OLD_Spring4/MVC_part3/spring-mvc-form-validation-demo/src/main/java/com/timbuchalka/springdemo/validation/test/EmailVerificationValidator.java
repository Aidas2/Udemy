package com.timbuchalka.springdemo.validation.test;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.EmailValidator;

public class EmailVerificationValidator implements ConstraintValidator<EmailVerification, String> {
	
	private String message;

	@Override
	public void initialize(EmailVerification constraintAnnotation) {
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		
		EmailValidator emailValidator = EmailValidator.getInstance();
		if(email ==  null) {
			return false;
		}
		if(!emailValidator.isValid(email)) {
			return false;
		}
		
		return true;
	}
	
	

}
