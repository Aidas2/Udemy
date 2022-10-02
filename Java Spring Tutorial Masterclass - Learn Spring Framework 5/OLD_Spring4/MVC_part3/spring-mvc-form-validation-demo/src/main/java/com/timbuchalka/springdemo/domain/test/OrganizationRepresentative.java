package com.timbuchalka.springdemo.domain.test;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.timbuchalka.springdemo.validation.test.AgeConstraint;
import com.timbuchalka.springdemo.validation.test.EmailVerification;
import com.timbuchalka.springdemo.validation.test.FieldsVerification;

@FieldsVerification.List({
	@FieldsVerification(
		field = "email",
		fieldMatch = "verifyEmail",
		message = " * Email addresses do not match"
	),
	@FieldsVerification(
			field = "password",
			fieldMatch = "verifyPassword",
			message = " * Passwords do not match"
	)
})

public class OrganizationRepresentative {
	
	@NotBlank(message="* First Name: cannot be blank")
	private String firstName;
	
	@NotEmpty(message="* Surname: cannot be empty")
	@Size(min=3, max=10, message="* Surname: min 3 characters required, max 10 characters allowed")
	private String lastName;
	
	@AgeConstraint (lower=20, upper=70, message="* Age: range 20 to 70 only")
	private Integer age;
	
	@NotBlank(message="* Zipcode: cannot be empty")
	@Pattern(regexp="^[a-zA-Z-0-9]{6}", message="* Zipcode: 6 characters and/or digits only")
	private String zipCode;

	@EmailVerification(message="* Email: is invalid")
	@NotBlank(message="* Email cannot be blank")
	private String email;
	
	@NotBlank(message="* Email cannot be blank")
	private String verifyEmail;
		
	@NotBlank(message="* Password cannot be blank")
	private String password;

	@NotBlank(message="* Password cannot be blank")
	private String verifyPassword;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVerifyEmail() {
		return verifyEmail;
	}

	public void setVerifyEmail(String verifyEmail) {
		this.verifyEmail = verifyEmail;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}


}
