package com.lennard.monsanto.model;

public class OperationStatus {
	private boolean success;
	private String message;
	
	public OperationStatus() {}
	
	public OperationStatus(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
