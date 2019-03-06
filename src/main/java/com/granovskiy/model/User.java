package com.granovskiy.model;

public class User {
    private Long id;
    private String username;
    private String password;
    private String token;
    private String firstName;
    private String lastName;

    public User(Long id, String username, String password, String token, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.token = token;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static User of(String username, String password) {
        return new User(username, password);
    }
}
