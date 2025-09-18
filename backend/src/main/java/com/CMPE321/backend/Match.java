package com.CMPE321.backend;

import java.time.LocalDate;

public class Match {
    private int matchId;
    private int hallId;
    private int tableId;
    private int whitePlayerTeam;
    private String whitePlayer;
    private int blackPlayerTeam;
    private String blackPlayer;
    private String result;
    private Integer timeSlot;
    private LocalDate date;
    private String assignedArbiterUsername;
    private Integer rating;
    private String creatorCoachUsername;

    public Match() {}

    public Match(int matchId, int hallId, int tableId, int whitePlayerTeam, String whitePlayer,
                 int blackPlayerTeam, String blackPlayer, String result, Integer timeSlot,
                 LocalDate date, String assignedArbiterUsername, Integer rating, String creatorCoachUsername) {
        this.matchId = matchId;
        this.hallId = hallId;
        this.tableId = tableId;
        this.whitePlayerTeam = whitePlayerTeam;
        this.whitePlayer = whitePlayer;
        this.blackPlayerTeam = blackPlayerTeam;
        this.blackPlayer = blackPlayer;
        this.result = result;
        this.timeSlot = timeSlot;
        this.date = date;
        this.assignedArbiterUsername = assignedArbiterUsername;
        this.rating = rating;
        this.creatorCoachUsername = creatorCoachUsername;
    }

    // Getters and setters
    public int getMatchId() { return matchId; }
    public void setMatchId(int matchId) { this.matchId = matchId; }

    public int getHallId() { return hallId; }
    public void setHallId(int hallId) { this.hallId = hallId; }

    public int getTableId() { return tableId; }
    public void setTableId(int tableId) { this.tableId = tableId; }

    public int getWhitePlayerTeam() { return whitePlayerTeam; }
    public void setWhitePlayerTeam(int whitePlayerTeam) { this.whitePlayerTeam = whitePlayerTeam; }

    public String getWhitePlayer() { return whitePlayer; }
    public void setWhitePlayer(String whitePlayer) { this.whitePlayer = whitePlayer; }

    public int getBlackPlayerTeam() { return blackPlayerTeam; }
    public void setBlackPlayerTeam(int blackPlayerTeam) { this.blackPlayerTeam = blackPlayerTeam; }

    public String getBlackPlayer() { return blackPlayer; }
    public void setBlackPlayer(String blackPlayer) { this.blackPlayer = blackPlayer; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }

    public Integer getTimeSlot() { return timeSlot; }
    public void setTimeSlot(Integer timeSlot) { this.timeSlot = timeSlot; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getAssignedArbiterUsername() { return assignedArbiterUsername; }
    public void setAssignedArbiterUsername(String assignedArbiterUsername) { this.assignedArbiterUsername = assignedArbiterUsername; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getCreatorCoachUsername() { return creatorCoachUsername; }
    public void setCreatorCoachUsername(String creatorCoachUsername) { this.creatorCoachUsername = creatorCoachUsername; }
}