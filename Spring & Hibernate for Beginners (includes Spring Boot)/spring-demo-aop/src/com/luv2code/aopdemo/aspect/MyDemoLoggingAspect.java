package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice

//	@Before("execution(public void addAccount())")		// match on any class
//	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO addAccount())") // match on only specified class
//	@Before("execution(public void add*())")			// match on any method starting with "add"
//	@Before("execution(void add*())")					// match on any return type void (modifier is optional)
//	@Before("execution(* add*())")						// match on any return type
	
//	@Before("execution(* add*(com.luv2code.aopdemo.Account))")	// match on only for having specified parameter type
//	@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")	// match on any number of parameters
//	@Before("execution(* add*(..))")					// match on any parameters (0 to many)
	
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")	// match only specified package (but any class and any method and any parameters)
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on method()");
		
	}
}










