package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean f rom spring container
//		Coach theCoach = context.getBean("thatSillyCoach", Coach.class); // explicit bean id
		Coach theCoach = context.getBean("tennisCoach", Coach.class); // default bean id
		
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());		
		
		
		// ===== PRACTICE #5 (partly) =====
		Coach swimmCoach = context.getBean("swimmCoach", Coach.class); // default bean id
		System.out.println("SwimmCoach properties: " + swimmCoach.getEmail() + ", " + swimmCoach.getTeam());
				
		// close the context
		context.close();
		
	}

}


