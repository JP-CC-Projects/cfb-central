package com.jpcc.CFBProject.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "game_media")
public class GameMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer season;
    private Integer week;
    private String seasonType;
    private String startTime;
    private Boolean isStartTimeTBD;
    private String homeTeam;
    private String homeConference;
    private String awayTeam;
    private String awayConference;
    private String mediaType;
    private String outlet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(String seasonType) {
        this.seasonType = seasonType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Boolean getStartTimeTBD() {
        return isStartTimeTBD;
    }

    public void setStartTimeTBD(Boolean startTimeTBD) {
        isStartTimeTBD = startTimeTBD;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getHomeConference() {
        return homeConference;
    }

    public void setHomeConference(String homeConference) {
        this.homeConference = homeConference;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getAwayConference() {
        return awayConference;
    }

    public void setAwayConference(String awayConference) {
        this.awayConference = awayConference;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getOutlet() {
        return outlet;
    }

    public void setOutlet(String outlet) {
        this.outlet = outlet;
    }
}
