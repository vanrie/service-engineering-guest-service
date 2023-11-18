package com.example.guestservice.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.guestservice.api.model.Participation;
import com.example.guestservice.service.ParticipationService;

@RestController
public class ParticipationController {

	    private ParticipationService pService;

	    @Autowired
	    public ParticipationController(ParticipationService pService){
	        this.pService = pService;
	    }

	    @GetMapping("/getAllParticipations")
	    public List<Participation> getAllParticipations(){
	        return pService.getAllParticipations();
	    }
	    
	    @GetMapping("/getParticipationById/{username}/{eventName}")
	    public Participation getParticipation(@PathVariable String username, @PathVariable String eventName){
	        return pService.getParticipationById(username, eventName);
	    }

	    @PostMapping("/createParticipation")
	    public ResponseEntity<Participation> createParticipation(@RequestBody Participation p) {
	    	Participation createdParticipation = pService.createParticipation(p);
	        return new ResponseEntity<>(createdParticipation, HttpStatus.CREATED);
	    }

	    @DeleteMapping("/deleteParticipation/{username}/{eventName}")
	    public ResponseEntity<Void> deleteParticipation(@PathVariable String username, @PathVariable String eventName) {
	    	pService.deleteParticipation(username, eventName);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    @DeleteMapping("/deleteParticipationOfUser/{username}")
	    public ResponseEntity<Void> deleteParticipationOfUser(@PathVariable String username) {
	    	pService.deleteParticipationOfUser(username);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    @DeleteMapping("/deleteParticipationOfEvent/{eventName}")
	    public ResponseEntity<Void> deleteParticipationOfEvent(@PathVariable String eventName) {
	    	pService.deleteParticipationOfEvent(eventName);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
