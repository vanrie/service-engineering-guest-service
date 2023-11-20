package com.example.guestservice.api.controller;

import com.example.guestservice.api.model.Event;
import com.example.guestservice.service.EventService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
@RestController
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllEvents")
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }

    @GetMapping("/getEventById/{name}")
    public Event getEvent(@PathVariable String name){
        return eventService.getEventById(name);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/createEvent")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    @PutMapping("/updateEvent/{name}")
    public ResponseEntity<Event> updateEvent(@PathVariable String name, @RequestBody Event event) {
        Event updatedevent = eventService.updateEvent(name, event);
        return ResponseEntity.ok(updatedevent);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deleteEvent/{name}")
    public ResponseEntity<Void> deleteEvent(@PathVariable String name) {
        eventService.deleteEvent(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


