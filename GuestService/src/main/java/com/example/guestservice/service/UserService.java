package com.example.guestservice.service;

import com.example.guestservice.api.db.QueryRepository;
import com.example.guestservice.api.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private QueryRepository repository;
    private List<User> userList;

    public UserService(){
        userList = new ArrayList<>();
    }

    public User getUser(String email){
        for(User user: userList) {
            if (email==user.getEmail()) {
                return user;
            }
        }
        return null;
    }

    public User createUser(User user) {
        for(User user1: userList){
            if(user1.getEmail().equals(user.getEmail())) {
                System.out.println("User already exists");
                return null;
            }
        }
        userList.add(user);
        repository.createUser(user);
        System.out.println("User added successfully");
        return user;
    }

    public User updateUser(String email, User user) {
        for(User oldUser : userList){
            if(oldUser.getEmail().equals(user.getEmail())) {
               userList.remove(oldUser);
               userList.add(user);
               repository.updateUser(user, oldUser);
               System.out.println("User updated successfully");
               return user;
            }
        }
        System.out.println("User doesn't exist");
        return null;
    }

    public void deleteUser(String email) {
        for(User user : userList){
            if(user.getEmail().equals(email)){
                userList.remove(user);
                repository.deleteUser(user);
                System.out.println("User deleted successfully");
                return;
            }
        }
        System.out.println("User doesn't exist");
        return;
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
