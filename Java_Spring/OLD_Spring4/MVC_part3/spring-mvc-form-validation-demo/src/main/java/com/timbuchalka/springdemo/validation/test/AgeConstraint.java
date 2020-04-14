package com.timbuchalka.springdemo.validation.test;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy=AgeConstraintValidator.class)
public @interface AgeConstraint {
	
	// message attribute
	String message() default "* Age must be between 18 and 60 years";
	
	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default { };
	
	// lower attribute
	int lower() default 18;
	
	// upper attribute
	int upper() default 60;
}
