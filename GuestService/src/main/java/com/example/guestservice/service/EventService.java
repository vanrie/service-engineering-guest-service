package com.example.guestservice.service;

import com.example.guestservice.api.model.Event;
import com.example.guestservice.api.model.User;

import java.util.ArrayList;
import java.util.List;

public class EventService {

    private List<Event> eventList;

    public EventService(){
        eventList = new ArrayList<>();
    }

    public Event getEvent(String name){
        for(Event event: eventList){
            if (name==event.getName()){
                return event;
            }
        }
        return null;
    }

    public Event createEvent(Event event) {
        for(Event event1: eventList){
            if(event1.getName().equals(event.getName())) {
                System.out.println("event already exists");
                return null;
            }
        }
        eventList.add(event);
        return event;
    }

    public Event updateEvent(String name, Event event) {
        for(Event event1 : eventList){
            if(event1.getName().equals(event.getName())) {
                eventList.remove(event1);
                eventList.add(event);
            }
        }
        System.out.println("User don't exists");
        return event;
    }

    public void deleteEvent(String name) {
        for(Event event : eventList){
            if(event.getName().equals(event.getName())){
                eventList.remove(event);
            }
        }
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
