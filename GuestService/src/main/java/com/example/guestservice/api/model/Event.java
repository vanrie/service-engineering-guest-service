package com.example.guestservice.api.model;

import java.util.Date;

public class Event {
    private Date date;
    private String name;

    //private Set<Event> events = new HashSet<>();

    public Event(Date date, String name) {
        this.date = date;
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String name){
        this.name = name;
    }
}
