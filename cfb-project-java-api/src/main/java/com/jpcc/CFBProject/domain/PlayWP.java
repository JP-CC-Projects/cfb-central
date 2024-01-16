package com.jpcc.CFBProject.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "play_wp")
public class PlayWP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long gamesId;
    private Long playId;
    private String playText;
    private Integer homeId;
    private String home;
    private Integer awayId;
    private String away;
    private Double spread;
    private Boolean homeBall;
    private Integer homeScore;
    private Integer awayScore;
    private Integer timeRemaining;
    private Integer yardLine;
    private Integer down;
    private Integer distance;
    private Double homeWinProb;
    private Integer playNumber;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGamesId() {
        return gamesId;
    }

    public void setGamesId(Long gamesId) {
        this.gamesId = gamesId;
    }

    public Long getPlayId() {
        return playId;
    }

    public void setPlayId(Long playId) {
        this.playId = playId;
    }

    public String getPlayText() {
        return playText;
    }

    public void setPlayText(String playText) {
        this.playText = playText;
    }

    public Integer getHomeId() {
        return homeId;
    }

    public void setHomeId(Integer homeId) {
        this.homeId = homeId;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public Integer getAwayId() {
        return awayId;
    }

    public void setAwayId(Integer awayId) {
        this.awayId = awayId;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public Double getSpread() {
        return spread;
    }

    public void setSpread(Double spread) {
        this.spread = spread;
    }

    public Boolean getHomeBall() {
        return homeBall;
    }

    public void setHomeBall(Boolean homeBall) {
        this.homeBall = homeBall;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Integer awayScore) {
        this.awayScore = awayScore;
    }

    public Integer getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(Integer timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public Integer getYardLine() {
        return yardLine;
    }

    public void setYardLine(Integer yardLine) {
        this.yardLine = yardLine;
    }

    public Integer getDown() {
        return down;
    }

    public void setDown(Integer down) {
        this.down = down;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Double getHomeWinProb() {
        return homeWinProb;
    }

    public void setHomeWinProb(Double homeWinProb) {
        this.homeWinProb = homeWinProb;
    }

    public Integer getPlayNumber() {
        return playNumber;
    }

    public void setPlayNumber(Integer playNumber) {
        this.playNumber = playNumber;
    }
}
