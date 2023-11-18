package com.example.guestservice.api.model;

public class Participation {

	private String username;
	private String eventName;
	
	public Participation(String username, String eventName) {
		this.username = username;
		this.eventName = eventName;
	}

	public String getUsername() {
		return username;
	}

	public String getEventName() {
		return eventName;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	
}
