package com.luv2code.springboot.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleaf.model.User;

@Controller
@RequestMapping("/users")
public class UserController {

	// load employee data
	
	private List<User> theUsers;
	
	@PostConstruct
	private void loadData() {
		
		// create users
		User user1 = new User(1, "Leslie", "Andrews", "leslie@luv2code.com");
		User user2 = new User(2, "Emma", "Baumgarten", "emma@luv2code.com");
		User user3 = new User(3, "Avani", "Gupta", "avani@luv2code.com");

		// create the list
		theUsers = new ArrayList<>();
		
		// add to the list
		theUsers.add(user1);
		theUsers.add(user2);
		theUsers.add(user3);
	
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// add to the spring model
		theModel.addAttribute("users", theUsers);
		
		return "list-users";
	}
}









