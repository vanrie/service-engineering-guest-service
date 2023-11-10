package com.example.guestservice.service;

import com.example.guestservice.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> userList;

    public UserService(){
        userList = new ArrayList<>();
    }

    public User getUser(String email){
        for(User user: userList){
            if (email==user.getEmail()){
                return user;
            }
        }
        return null;
    }

    public User createUser(User user) {
        for(User user1: userList){
            if(user1.getEmail().equals(user.getEmail())) {
                System.out.println("user already exists");
                return null;
            }
        }
        userList.add(user);
        return user;
    }

    public User updateUser(String email, User user) {
        for(User user1 : userList){
            if(user1.getEmail().equals(user.getEmail())) {
               userList.remove(user1);
               userList.add(user);
            }
        }
        System.out.println("User don't exists");
        return user;
    }

    public void deleteUser(String email) {
        for(User user : userList){
            if(user.getEmail().equals(email)){
                userList.remove(user);
            }
        }
    }
    /*
    public User joinEvent(Integer userId, Integer eventId) {
        User user = userRepository.findById(userId).orElse(null);
        Event event = eventRepository.findById(eventId).orElse(null);

        if (user != null && event != null) {
            user.getEvents().add(event);
            userRepository.save(user);
        }

        return user;
    }
    */
}
