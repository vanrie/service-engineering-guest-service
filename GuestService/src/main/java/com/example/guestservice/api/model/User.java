package com.example.guestservice.api.model;

public class User {
    private String name;
    private String email;
    private String pw;

    public User(String name, String email, String pw) {
        this.name = name;
        this.email = email;
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPw() {
        return pw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
