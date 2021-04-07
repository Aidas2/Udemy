package com.luv2code.practice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.springdemo.Coach;

public class PracticeAnnotationDemo {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("practice-applicationContext.xml");
		
		Coach pingPongCoach = context.getBean("pingPongCoach", Coach.class); // default bean id
		
		// ===== PRACTICE #4 =====
		System.out.println(pingPongCoach.getDailyWorkout());
		
		// ===== PRACTICE #5 =====
		System.out.println(pingPongCoach.getDailyFortune());
		
		
		context.close();
	}
	
}
