package com.example.guestservice.service;

import com.example.guestservice.api.db.QueryRepository;
import com.example.guestservice.api.model.Event;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private QueryRepository repository;
    private List<Event> eventList;

    public EventService(){
        eventList = new ArrayList<>();
    }

    public List<Event> getAllEvents(){
        return eventList;
    }

    public Event getEvent(String name) {
        for(Event event: eventList){
            if (name==event.getName()) {
                return event;
            }
        }
        return null;
    }

    public Event createEvent(Event event) {
        for(Event event1: eventList){
            if(event1.getName().equals(event.getName())) {
                System.out.println("Event already exists");
                return null;
            }
        }
        eventList.add(event);
        repository.createEvent(event);
        System.out.println("Event added successfully");
        return event;
    }

    public Event updateEvent(String name, Event event) {
        for(Event oldEvent : eventList){
            if(oldEvent.getName().equals(name)) {
                eventList.remove(oldEvent);
                eventList.add(event);
                repository.updateEvent(event, oldEvent);
                System.out.println("Event updated successfully");
                return event;
            }
        }
        System.out.println("Event doesn't exist");
        return null;
    }

    public void deleteEvent(String name) {
        for(Event event : eventList){
            if(event.getName().equals(event.getName())){
                eventList.remove(event);
                repository.deleteEvent(event);
                System.out.println("Event deleted successfully");
                return;
            }
        }
        System.out.println("Event doesn't exist");
        return;
    }
    /*
    public Event addUserToEvent(Integer userId, Integer eventId) {
        User user = userRepository.findById(userId).orElse(null);
        Event event = eventRepository.findById(eventId).orElse(null);

        if (user != null && event != null) {
            event.getUsers().add(user);
            eventRepository.save(event);
        }

        return event;
    }

     */
}
