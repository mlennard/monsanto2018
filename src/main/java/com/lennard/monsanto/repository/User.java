package com.lennard.monsanto.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class User {

	@Id
	private String id;
	
	private String userName;
	private String userPassword;
	private List<Integer> locations = new ArrayList<Integer>();
	
	public User() {}

	public User(String userName, String userPassword, List<Integer> locations) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.locations = locations;
	}
	
	public User(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + ", locations="
				+ locations + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<Integer> getLocations() {
		return locations;
	}

	public void setLocations(List<Integer> locations) {
		this.locations = locations;
	}
	
}
