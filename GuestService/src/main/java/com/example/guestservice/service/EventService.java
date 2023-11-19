package com.example.guestservice.service;

import com.example.guestservice.api.db.QueryRepository;
import com.example.guestservice.api.model.Event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private QueryRepository repository;
    private List<Event> eventList;

    public EventService() {
        //eventList = repository.getAllEvents();
        eventList = new ArrayList<Event>();
    }

    public List<Event> getAllEvents() {
        return eventList;
    }

    public Event getEventById(String name) {
        for(Event event: eventList) {
            if (event.getName().equals(name)) {
                return event;
            }
        }
        return null;
    }

    public Event createEvent(Event event) {
        for(Event event1: eventList) {
            if(event1.getName().equals(event.getName())) {
                System.out.println("Event already exists");
                return null;
            }
        }
        repository.createEvent(event);
        eventList.add(event);
        System.out.println("Event added successfully");
        return event;
    }

    public Event updateEvent(String name, Event event) {
        for(Event oldEvent : eventList) {
            if(oldEvent.getName().equals(name)) {
            	repository.updateEvent(event, oldEvent);
            	eventList.remove(oldEvent);
                eventList.add(event);
                System.out.println("Event updated successfully");
                return event;
            }
        }
        System.out.println("Event doesn't exist");
        return null;
    }

    public void deleteEvent(String name) {
        for(Event event : eventList) {
            if(event.getName().equals(event.getName())) {
            	repository.deleteEvent(event);
                eventList.remove(event);
                System.out.println("Event deleted successfully");
                return;
            }
        }
        System.out.println("Event doesn't exist");
        return;
    }
}
