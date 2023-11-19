package com.example.guestservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.guestservice.api.db.QueryRepository;
import com.example.guestservice.api.model.Participation;

@Service
public class ParticipationService {

    @Autowired
    private QueryRepository repository;
    private List<Participation> participationList;

    public ParticipationService() {
    	//participationList = repository.getAllParticipations();
    	participationList = new ArrayList<Participation>();
    }

    public List<Participation> getAllParticipations() {
        return participationList;
    }

    public Participation getParticipationById(String username, String eventName) {
        for(Participation p: participationList) {
            if (p.getUsername().equals(username) && p.getEventName().equals(eventName)) {
                return p;
            }
        }
        return null;
    }

    public Participation createParticipation(Participation p) {
        for(Participation p1: participationList) {
            if(p1.getUsername().equals(p.getUsername()) && p1.getEventName().equals(p.getEventName())) {
                System.out.println("Participation already exists");
                return null;
            }
        }
        repository.createParticipation(p);
        participationList.add(p);
        System.out.println("Participation added successfully");
        return p;
    }

    public void deleteParticipation(String username, String eventName) {
    	for(Participation p: participationList) {
            if(p.getUsername().equals(username) && p.getEventName().equals(eventName)) {
            	repository.deleteParticipation(p);
                participationList.remove(p);
                System.out.println("Participation deleted successfully");
                return;
            }
        }
        System.out.println("Participation doesn't exist");
        return;
    }
    
    public void deleteParticipationOfUser(String username) {
    	for(Participation p: participationList) {
            if(p.getUsername().equals(username)) {
            	repository.deleteParticipation(p);
                participationList.remove(p);
                System.out.println("Participation deleted successfully");
            }
        }
        return;
    }
    
    public void deleteParticipationOfEvent(String eventName) {
    	for(Participation p: participationList) {
            if(p.getEventName().equals(eventName)) {
            	repository.deleteParticipation(p);
                participationList.remove(p);
                System.out.println("Participation deleted successfully");
                return;
            }
        }
        return;
    }
}
