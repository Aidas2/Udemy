package com.luv2code.random;

import com.luv2code.springdemo.Coach;
import com.luv2code.springdemo.FortuneService;

public class GolfCoach implements Coach {
	
	FortuneService fortuneService;
	
	// create a no-arg constructor
	public GolfCoach() {
		System.out.println("GolfCoach: inside no-arg constructor");
	}
	
	public GolfCoach(RandomFortuneService randomFortuneService) {
		this.fortuneService = randomFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your putting skills for 2 hours today";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	// add an init method
	public void doMyStartupStuff() {
		System.out.println("GolfCoach: inside method doMyStartupStuff");
	}
	
	// add a destroy method
	public void doMyCleanupStuffYoYo() {
		System.out.println("GolfCoach: inside method doMyCleanupStuffYoYo");		
	}

}
