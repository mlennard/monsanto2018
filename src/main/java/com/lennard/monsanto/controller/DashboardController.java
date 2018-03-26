package com.lennard.monsanto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lennard.monsanto.model.UserLocations;
import com.lennard.monsanto.repository.User;
import com.lennard.monsanto.repository.UserRepository;

@RestController
@RequestMapping(value="/dashboard")
public class DashboardController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping(value="/currentUser", produces="application/json", consumes="application/json" )
	public ResponseEntity<UserLocations> getUserLocations(@RequestParam String userName){
		User user = repository.findByUserName(userName).get();
		
		return ResponseEntity.ok(new UserLocations(user.getLocations()));
	}

}
