package com.lennard.monsanto.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	public Optional<User> findByUserNameAndUserPassword(String userName, String userPassword);
	public Optional<User> findByUserName(String userName);
	
}
