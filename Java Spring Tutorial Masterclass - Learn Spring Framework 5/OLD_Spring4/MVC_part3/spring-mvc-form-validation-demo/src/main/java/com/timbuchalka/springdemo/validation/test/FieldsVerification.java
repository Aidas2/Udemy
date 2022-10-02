package com.timbuchalka.springdemo.validation.test;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = FieldsVerificationValidator.class)
public @interface FieldsVerification {
	
	String message() default "* Field values do not match";
	String field();
	String fieldMatch();
	
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
	
	@Retention(RUNTIME)
	@Target(ElementType.TYPE)
	@interface List {
		FieldsVerification[] value();
	}

}
