package com.luv2code.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.luv2code.springdemo.Coach;
import com.luv2code.springdemo.FortuneService;

@Component
public class PingPongCoach implements Coach {
	
	@Autowired
	@Qualifier("practiceFortuneService")
//	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;

	// define a default constructor
	public PingPongCoach() {
		System.out.println(">> PingPongCoach: inside default constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		return "ping pong ping pong ping pong ping pong ping pong ping pong ";
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
