package com.example.guestservice.api.model;

public class User {
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean isAdmin;

    public User(String username, String email, String password, String firstName, String lastName
            , Boolean isAdmin) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean isAdmin() {
        return isAdmin;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
