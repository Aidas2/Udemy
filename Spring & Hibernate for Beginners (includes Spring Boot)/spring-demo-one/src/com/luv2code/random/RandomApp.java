package com.luv2code.random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RandomApp {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
		new ClassPathXmlApplicationContext("random-applicationContext.xml");
	 
		GolfCoach theCoach = context.getBean("myGolfCoach", GolfCoach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
		}
	
}
