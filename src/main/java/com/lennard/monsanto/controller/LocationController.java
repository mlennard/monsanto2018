package com.lennard.monsanto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lennard.monsanto.model.OperationStatus;
import com.lennard.monsanto.repository.User;
import com.lennard.monsanto.repository.UserRepository;

@RestController
@RequestMapping(value="/location")
public class LocationController {
	
	@Autowired
	private UserRepository repository;
	
	@PatchMapping(value="/add", produces="application/json", consumes="application/json" )
	public ResponseEntity<OperationStatus> addLocation(@RequestParam String userName, @RequestBody Integer location) {
		User user = repository.findByUserName(userName).get();
		Optional<List<Integer>> locations = Optional.ofNullable(user.getLocations());
		if(locations.isPresent()) {
			user.getLocations().add(location);
		} else {
			List<Integer> newlocations = new ArrayList<Integer>();
			newlocations.add(location);
			user.setLocations(newlocations);
		}
		repository.save(user);		
		return ResponseEntity.ok(new OperationStatus(true,"Locacion agregada con exito"));
	}
	
	@PatchMapping(value="/remove", produces="application/json", consumes="application/json" )
	public ResponseEntity<OperationStatus> removeLocation(@RequestParam String userName, @RequestBody Integer location) {
		User user = repository.findByUserName(userName).get();
		Optional<List<Integer>> locations = Optional.ofNullable(user.getLocations()); 
		if(locations.isPresent()) {
			locations.get().remove(location);
			user.setLocations(locations.get());
		}
		repository.save(user);		
		return ResponseEntity.ok(new OperationStatus(true,"Locacion removida con exito"));
	}
}
