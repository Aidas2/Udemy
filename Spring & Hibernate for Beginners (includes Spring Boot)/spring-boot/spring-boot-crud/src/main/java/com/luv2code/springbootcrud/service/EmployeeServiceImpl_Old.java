package com.luv2code.springbootcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springbootcrud.dao.EmployeeDAO;
import com.luv2code.springbootcrud.entity.Employee;
/*
@Service
public class EmployeeServiceImpl_Old implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
// 	Version_01_Hibernate. There is only one bean (using bean "employeeDAOHibernateImpl")	
//	@Autowired	
//	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
//		employeeDAO = theEmployeeDAO;
//	}
	
// 	Version_02_Jpa. The is more beans, specified bean (using bean "employeeDAOJpaImpl")
	@Autowired 
	public EmployeeServiceImpl_Old(@Qualifier("employeeDAOJpaImpl") EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
	}

}

*/




