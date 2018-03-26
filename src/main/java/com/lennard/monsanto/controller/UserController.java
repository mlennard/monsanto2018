package com.lennard.monsanto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lennard.monsanto.model.OperationStatus;
import com.lennard.monsanto.model.UserDTO;
import com.lennard.monsanto.repository.User;
import com.lennard.monsanto.repository.UserRepository;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@PostMapping(value="/create", produces="application/json", consumes="application/json")
	public ResponseEntity<OperationStatus> createUser(@RequestBody UserDTO user){
		User u = repository.findByUserName(user.getName()).orElse(null);
		final OperationStatus status = new OperationStatus();
		if(u != null) {
			//Si existe el user
			status.setSuccess(false); 
			status.setMessage("El nombre de usuario ya existe");
		} else {
			//Si el user no existe
			u = new User();
			u.setUserName(user.getName());
			u.setUserPassword(user.getPassword());
			repository.save(u);
			status.setSuccess(true); 
			status.setMessage("Usuario creado con exito");
		}
		return ResponseEntity.ok(status);
	}
	
	@PostMapping(value="/login", produces="application/json", consumes="application/json")
	public ResponseEntity<OperationStatus> login(@RequestBody UserDTO user){
		User u = repository.findByUserNameAndUserPassword(user.getName(), user.getPassword()).orElse(null);
		final OperationStatus status = new OperationStatus();
		if(u != null) {
			return ResponseEntity.ok(status);
		} else {
			status.setSuccess(false); 
			status.setMessage("Error en login: nombre o password invalido");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
}
