package com.luv2code.springbootcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luv2code.springbootcrud.entity.Employee;

//@RepositoryRestResource(path="members") // http://localhost:8080/magic-api/members
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!
	
}
