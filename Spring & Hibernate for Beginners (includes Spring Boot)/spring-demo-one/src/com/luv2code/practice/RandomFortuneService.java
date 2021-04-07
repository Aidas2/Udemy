package com.luv2code.practice;

import java.util.Random;

import com.luv2code.springdemo.FortuneService;

public class RandomFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		String [] fortunes = new String [] {
				"Beware of the wolf in sheep's clothing",
				"Diligence is the mother of good luck",
				"The journey is the reward"
				};
		int random = new Random().nextInt(fortunes.length);
		return fortunes[random];
	}

}
