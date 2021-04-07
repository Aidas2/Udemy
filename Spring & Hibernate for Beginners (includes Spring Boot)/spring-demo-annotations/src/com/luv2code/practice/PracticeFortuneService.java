package com.luv2code.practice;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.luv2code.springdemo.FortuneService;

@Component
public class PracticeFortuneService implements FortuneService {
	
	@Value("${foo.fortune01}")
	private String fortune_01;
	    
	@Value("${foo.fortune02}")
	private String fortune_02;
	
	@Value("${foo.fortune03}")
	private String fortune_03;
	
	public String[] data = new String [3];
	
	@PostConstruct
	private void createArray() {
		data[0]=fortune_01;
		data[1]=fortune_02;
		data[2]=fortune_03;
		System.out.println("@PostConstruct in PracticeFortuneService was called!");
	}

	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length);
		String theFortune = data[index];
		return theFortune;
		
	}

}
