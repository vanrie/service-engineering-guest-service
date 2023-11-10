package com.example.guestservice.api.controller;

import com.example.guestservice.api.model.Event;
import com.example.guestservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    public class EventController {

        private EventService eventService;

        @Autowired
        public EventController(EventService eventService){
            this.eventService = eventService;
        }

        @GetMapping("/event")
        public Event getEvent(@RequestParam String name){
            return eventService.getEvent(name);
        }

        @PostMapping
        public ResponseEntity<Event> createUEvent(@RequestBody Event event) {
            Event createdEvent = eventService.createEvent(event);
            return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
        }

        @PutMapping("/{name}")
        public ResponseEntity<Event> updateEvent(@PathVariable String name, @RequestBody Event event) {
            Event updatedevent = eventService.updateEvent(name, event);
            return ResponseEntity.ok(updatedevent);
        }

        @DeleteMapping("/{name}")
        public ResponseEntity<Void> deleteEvent(@PathVariable String name) {
            eventService.deleteEvent(name);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    /*
    @PostMapping("/{eventId}/add-user/{userId}")
    public ResponseEntity<Event> addUserToEvent(@PathVariable Integer eventId, @PathVariable Integer userId) {
        Event event = eventService.addUserToEvent(userId, eventId);

        if (event != null) {
            return ResponseEntity.ok(event);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
     */


