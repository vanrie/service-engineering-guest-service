package com.example.guestservice.service;

import com.example.guestservice.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private List<User> userList;

    public UserService(){
        userList = new ArrayList<>();

        User user1 = new User(1, "Tobi", 23);
        User user2 = new User(2, "Maxi", 24);

        userList.addAll(Arrays.asList(user1,user2));
    }

    public User getUser(Integer id){
        for(User user: userList){
            if (id==user.getId()){
                return user;
            }
        }
        return null;
    }
}
