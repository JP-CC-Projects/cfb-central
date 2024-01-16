package com.jpcc.CFBProject.domain;

import jakarta.persistence.*;
@Entity
@Table(name = "drive")
public class Drive {

    @Id
    private Long id;
    private String offense;
    private String offenseConference;
    private String defense;
    private String defenseConference;
    private Long gameId;
    private Integer driveNumber;
    private Boolean scoring;
    private Integer startPeriod;
    private Integer startYardline;
    private Integer startYardsToGoal;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "minutes", column = @Column(name = "start_time_minutes")),
            @AttributeOverride(name = "seconds", column = @Column(name = "start_time_seconds"))
    })
    private Time startTime;

    private Integer endPeriod;
    private Integer endYardline;
    private Integer endYardsToGoal;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "minutes", column = @Column(name = "end_time_minutes")),
            @AttributeOverride(name = "seconds", column = @Column(name = "end_time_seconds"))
    })
    private Time endTime;

    private Integer plays;
    private Integer yards;
    private String driveResult;
    private Boolean isHomeOffense;
    private Integer startOffenseScore;
    private Integer startDefenseScore;
    private Integer endOffenseScore;
    private Integer endDefenseScore;

    @Embeddable
    public static class Time {
        private Integer minutes;
        private Integer seconds;

        // Getters and Setters

        public Integer getMinutes() {
            return minutes;
        }

        public void setMinutes(Integer minutes) {
            this.minutes = minutes;
        }

        public Integer getSeconds() {
            return seconds;
        }

        public void setSeconds(Integer seconds) {
            this.seconds = seconds;
        }
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOffense() {
        return offense;
    }

    public void setOffense(String offense) {
        this.offense = offense;
    }

    public String getOffenseConference() {
        return offenseConference;
    }

    public void setOffenseConference(String offenseConference) {
        this.offenseConference = offenseConference;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public String getDefenseConference() {
        return defenseConference;
    }

    public void setDefenseConference(String defenseConference) {
        this.defenseConference = defenseConference;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Integer getDriveNumber() {
        return driveNumber;
    }

    public void setDriveNumber(Integer driveNumber) {
        this.driveNumber = driveNumber;
    }

    public Boolean getScoring() {
        return scoring;
    }

    public void setScoring(Boolean scoring) {
        this.scoring = scoring;
    }

    public Integer getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(Integer startPeriod) {
        this.startPeriod = startPeriod;
    }

    public Integer getStartYardline() {
        return startYardline;
    }

    public void setStartYardline(Integer startYardline) {
        this.startYardline = startYardline;
    }

    public Integer getStartYardsToGoal() {
        return startYardsToGoal;
    }

    public void setStartYardsToGoal(Integer startYardsToGoal) {
        this.startYardsToGoal = startYardsToGoal;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Integer getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(Integer endPeriod) {
        this.endPeriod = endPeriod;
    }

    public Integer getEndYardline() {
        return endYardline;
    }

    public void setEndYardline(Integer endYardline) {
        this.endYardline = endYardline;
    }

    public Integer getEndYardsToGoal() {
        return endYardsToGoal;
    }

    public void setEndYardsToGoal(Integer endYardsToGoal) {
        this.endYardsToGoal = endYardsToGoal;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Integer getPlays() {
        return plays;
    }

    public void setPlays(Integer plays) {
        this.plays = plays;
    }

    public Integer getYards() {
        return yards;
    }

    public void setYards(Integer yards) {
        this.yards = yards;
    }

    public String getDriveResult() {
        return driveResult;
    }

    public void setDriveResult(String driveResult) {
        this.driveResult = driveResult;
    }

    public Boolean getHomeOffense() {
        return isHomeOffense;
    }

    public void setHomeOffense(Boolean homeOffense) {
        isHomeOffense = homeOffense;
    }

    public Integer getStartOffenseScore() {
        return startOffenseScore;
    }

    public void setStartOffenseScore(Integer startOffenseScore) {
        this.startOffenseScore = startOffenseScore;
    }

    public Integer getStartDefenseScore() {
        return startDefenseScore;
    }

    public void setStartDefenseScore(Integer startDefenseScore) {
        this.startDefenseScore = startDefenseScore;
    }

    public Integer getEndOffenseScore() {
        return endOffenseScore;
    }

    public void setEndOffenseScore(Integer endOffenseScore) {
        this.endOffenseScore = endOffenseScore;
    }

    public Integer getEndDefenseScore() {
        return endDefenseScore;
    }

    public void setEndDefenseScore(Integer endDefenseScore) {
        this.endDefenseScore = endDefenseScore;
    }
}
