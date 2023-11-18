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

    public UserService() {
        //userList = repository.getAllUsers();
    	userList = new ArrayList<User>();
    }

    public List<User> getAllUsers(){
        return userList;
    }

    public User getUserById(String username) {
        for(User user: userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User createUser(User user) {
        for(User user1: userList) {
            if(user1.getUsername().equals(user.getUsername())) {
                System.out.println("User already exists");
                return user1;
            }
        }
        repository.createUser(user);
        userList.add(user);
        System.out.println("User added successfully");
        return user;
    }
    
    public User updateUser(String username, User user) {
        for(User oldUser: userList){
            if(oldUser.getUsername().equals(username)) {
               repository.updateUser(user, oldUser);
               userList.remove(oldUser);
               userList.add(user);
               System.out.println("User updated successfully");
               return user;
            }
        }
        System.out.println("User doesn't exist");
        return null;
    }

    public void deleteUser(String username) {
        for(User user : userList){
            if(user.getEmail().equals(username)){
            	repository.deleteUser(user);
            	userList.remove(user);
                System.out.println("User deleted successfully");
                return;
            }
        }
        System.out.println("User doesn't exist");
        return;
    }
}
