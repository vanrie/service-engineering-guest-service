package com.example.guestservice.api.model;

public class User {
    private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastName;

    public User(String username, String email, String password, String firstname, String lastName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastName = lastName;
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

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
