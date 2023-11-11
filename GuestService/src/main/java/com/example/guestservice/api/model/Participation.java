package com.example.guestservice.api.model;

public class Participation {

	private String userEmail;
	private String eventName;
	
	public Participation(String userEmail, String eventName) {
		this.userEmail = userEmail;
		this.eventName = eventName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getEventName() {
		return eventName;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	
}
