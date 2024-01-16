package com.jpcc.CFBProject.domain.boxscore;

import jakarta.persistence.Embeddable;

@Embeddable
public class BoxScoreGameInfo {

    private String homeTeam;
    private int homePoints;
    private double homeWinProb;
    private String awayTeam;
    private int awayPoints;
    private double awayWinProb;
    private boolean homeWinner;
    private double excitement;

    // Constructors, getters, and setters
    public BoxScoreGameInfo() {}

    // Additional constructors, getters, and setters as needed

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getHomePoints() {
        return homePoints;
    }

    public void setHomePoints(int homePoints) {
        this.homePoints = homePoints;
    }

    public double getHomeWinProb() {
        return homeWinProb;
    }

    public void setHomeWinProb(double homeWinProb) {
        this.homeWinProb = homeWinProb;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getAwayPoints() {
        return awayPoints;
    }

    public void setAwayPoints(int awayPoints) {
        this.awayPoints = awayPoints;
    }

    public double getAwayWinProb() {
        return awayWinProb;
    }

    public void setAwayWinProb(double awayWinProb) {
        this.awayWinProb = awayWinProb;
    }

    public boolean isHomeWinner() {
        return homeWinner;
    }

    public void setHomeWinner(boolean homeWinner) {
        this.homeWinner = homeWinner;
    }

    public double getExcitement() {
        return excitement;
    }

    public void setExcitement(double excitement) {
        this.excitement = excitement;
    }

}
