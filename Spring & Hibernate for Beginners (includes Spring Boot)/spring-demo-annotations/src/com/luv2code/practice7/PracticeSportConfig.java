package com.luv2code.practice7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.luv2code.springdemo.Coach;
import com.luv2code.springdemo.FortuneService;

@Configuration
public class PracticeSportConfig {
		
	// define bean for our happy fortune service
	@Bean
	public FortuneService happyFortuneService() {
		return new HappyFortuneService();
	}
	
	// define bean for our swim coach AND inject dependency
	@Bean
	public Coach wrestlingCoach() {
		WrestlingCoach myWrestlingCoach = new WrestlingCoach(happyFortuneService());
		
		return myWrestlingCoach;
	}
	
}








