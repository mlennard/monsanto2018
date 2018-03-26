package com.lennard.monsanto.model;

import java.util.List;

public class UserLocations {
	private List<Integer> locations;

	public UserLocations(List<Integer> locations) {
		super();
		this.locations = locations;
	}

	public List<Integer> getLocations() {
		return locations;
	}

	public void setLocations(List<Integer> locations) {
		this.locations = locations;
	}
	
}
