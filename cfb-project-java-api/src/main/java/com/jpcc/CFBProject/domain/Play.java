package com.jpcc.CFBProject.domain;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "play")
public class Play {

    @Id
    private Long id;
    private Long driveId;
    private Long gameId;
    private Integer driveNumber;
    private Integer playNumber;
    private String offense;
    private String offenseConference;
    private Integer offenseScore;
    private String defense;
    private String home;
    private String away;
    private String defenseConference;
    private Integer defenseScore;
    private Integer period;

    @Embedded
    private Time clock;

    private Integer offenseTimeouts;
    private Integer defenseTimeouts;
    private Integer yardLine;
    private Integer yardsToGoal;
    private Integer down;
    private Integer distance;
    private Integer yardsGained;
    private Boolean scoring;
    private String playType;
    @Column(length = 1000)
    private String playText;
    private Double ppa;
    private Instant wallclock;

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

    public Long getDriveId() {
        return driveId;
    }

    public void setDriveId(Long driveId) {
        this.driveId = driveId;
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

    public Integer getPlayNumber() {
        return playNumber;
    }

    public void setPlayNumber(Integer playNumber) {
        this.playNumber = playNumber;
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

    public Integer getOffenseScore() {
        return offenseScore;
    }

    public void setOffenseScore(Integer offenseScore) {
        this.offenseScore = offenseScore;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public String getDefenseConference() {
        return defenseConference;
    }

    public void setDefenseConference(String defenseConference) {
        this.defenseConference = defenseConference;
    }

    public Integer getDefenseScore() {
        return defenseScore;
    }

    public void setDefenseScore(Integer defenseScore) {
        this.defenseScore = defenseScore;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Time getClock() {
        return clock;
    }

    public void setClock(Time clock) {
        this.clock = clock;
    }

    public Integer getOffenseTimeouts() {
        return offenseTimeouts;
    }

    public void setOffenseTimeouts(Integer offenseTimeouts) {
        this.offenseTimeouts = offenseTimeouts;
    }

    public Integer getDefenseTimeouts() {
        return defenseTimeouts;
    }

    public void setDefenseTimeouts(Integer defenseTimeouts) {
        this.defenseTimeouts = defenseTimeouts;
    }

    public Integer getYardLine() {
        return yardLine;
    }

    public void setYardLine(Integer yardLine) {
        this.yardLine = yardLine;
    }

    public Integer getYardsToGoal() {
        return yardsToGoal;
    }

    public void setYardsToGoal(Integer yardsToGoal) {
        this.yardsToGoal = yardsToGoal;
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

    public Integer getYardsGained() {
        return yardsGained;
    }

    public void setYardsGained(Integer yardsGained) {
        this.yardsGained = yardsGained;
    }

    public Boolean getScoring() {
        return scoring;
    }

    public void setScoring(Boolean scoring) {
        this.scoring = scoring;
    }

    public String getPlayType() {
        return playType;
    }

    public void setPlayType(String playType) {
        this.playType = playType;
    }

    public String getPlayText() {
        return playText;
    }

    public void setPlayText(String playText) {
        this.playText = playText;
    }

    public Double getPpa() {
        return ppa;
    }

    public void setPpa(Double ppa) {
        this.ppa = ppa;
    }

    public Instant getWallclock() {
        return wallclock;
    }

    public void setWallclock(Instant wallclock) {
        this.wallclock = wallclock;
    }
}
