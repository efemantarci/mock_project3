package com.CMPE321.backend.dto;

public class UserCreateRequest {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String nationality;

    public UserCreateRequest() {}

    public UserCreateRequest(String username, String password, String name, String surname, String nationality) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
