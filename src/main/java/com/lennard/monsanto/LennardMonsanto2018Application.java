package com.lennard.monsanto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LennardMonsanto2018Application {

//	@Autowired
//	private UserRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(LennardMonsanto2018Application.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		repository.deleteAll();
//		
//		List<Integer> locations = new ArrayList<Integer>();
//		locations.add(12);
//		locations.add(23);
//		
//		//Create users (con o sin locations)
//		repository.save(new User("nombre", "password"));
//		repository.save(new User("nombre1", "password1",locations));
//		
//		// fetch all customers
//		System.out.println("Users found with findAll():");
//		System.out.println("-------------------------------");
//		for (User customer : repository.findAll()) {
//			System.out.println(customer);
//		}
//		System.out.println();
//		
//		//Login
//		System.out.println("Login");
//		//
//		Optional<User> user = repository.findByUserNameAndUserPassword("nombre", "password");
//		System.out.println(user);
//		locations.add(123);
//		user.get().setLocations(locations);
//		repository.save(user.get());
//		user = repository.findById(user.get().getId());
//		System.out.println(user);
//		
//		//Failed login
//		System.out.println("Login failed");
//		user = repository.findByUserNameAndUserPassword("nombre", "password1");
//		System.out.println(user);
//		
//		
//		
//	}

	
	

}
