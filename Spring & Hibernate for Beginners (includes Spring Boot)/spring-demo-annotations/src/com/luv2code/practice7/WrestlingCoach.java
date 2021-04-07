package com.luv2code.practice7;

import org.springframework.stereotype.Component;

import com.luv2code.springdemo.Coach;
import com.luv2code.springdemo.FortuneService;

@Component
public class WrestlingCoach implements Coach {

	private FortuneService fortuneService;
			
	public WrestlingCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your double leg takedown.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTeam() {
		// TODO Auto-generated method stub
		return null;
	}

}
