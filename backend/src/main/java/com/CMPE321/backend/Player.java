package com.CMPE321.backend;

import java.time.LocalDate;

public class Player {
    private String username;
    private String name;
    private String surname;
    private String nationality;
    private LocalDate dateOfBirth;
    private String fideId;
    private int eloRating;
    private Integer titleId;
    private String titleName;

    public Player() {}

    public Player(String username, String name, String surname, String nationality,
                  LocalDate dateOfBirth, String fideId, int eloRating, Integer titleId, String titleName) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.fideId = fideId;
        this.eloRating = eloRating;
        this.titleId = titleId;
        this.titleName = titleName;
    }

    // Getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getFideId() { return fideId; }
    public void setFideId(String fideId) { this.fideId = fideId; }

    public int getEloRating() { return eloRating; }
    public void setEloRating(int eloRating) { this.eloRating = eloRating; }

    public Integer getTitleId() { return titleId; }
    public void setTitleId(Integer titleId) { this.titleId = titleId; }

    public String getTitleName() { return titleName; }
    public void setTitleName(String titleName) { this.titleName = titleName; }
}