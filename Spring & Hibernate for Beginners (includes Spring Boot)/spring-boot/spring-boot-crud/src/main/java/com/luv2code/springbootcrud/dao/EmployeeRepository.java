package com.luv2code.springbootcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springbootcrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!
	
}
