package com.luv2code.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.luv2code.springdemo.FortuneService;

@Component
public class FileFortuneService implements FortuneService {

	private String fileName = "E:\\DEV_Code\\Udemy_etc\\Spring & Hibernate for Beginners (includes Spring Boot)\\spring-demo-annotations\\src\\com\\luv2code\\practice\\fortune-data.txt";
	private List<String> theFortunes;

	// create a random number generator
	private Random myRandom = new Random();

	public FileFortuneService() {

		File theFile = new File(fileName);
		
		System.out.println("Reading fortunes from file: " + theFile);
		System.out.println("File exists: " + theFile.exists());
		
		// initialize array list
		theFortunes = new ArrayList<String>();
		
		// read fortunes from file
		try (BufferedReader br = new BufferedReader(
				new FileReader(theFile))) {

			String tempLine;

			while ((tempLine = br.readLine()) != null) {
				theFortunes.add(tempLine);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getFortune() {
		// pick a random string from the array
		int index = myRandom.nextInt(theFortunes.size());

		String tempFortune = theFortunes.get(index);

		return tempFortune;
	}

}
