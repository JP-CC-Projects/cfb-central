package com.jpcc.CFBProject.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "season_week")
public class SeasonWeek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or another appropriate strategy
    private Long id;
    private Integer season;

    @JsonProperty("week") // Maps the JSON field "week" to this Java field
    private Integer weekNumber;

    private String seasonType;

    private Instant firstGameStart;

    private Instant lastGameStart;


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

    public Integer getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(Integer weekNumber) {
        this.weekNumber = weekNumber;
    }

    public String getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(String seasonType) {
        this.seasonType = seasonType;
    }

    public Instant getFirstGameStart() {
        return firstGameStart;
    }

    public void setFirstGameStart(Instant firstGameStart) {
        this.firstGameStart = firstGameStart;
    }

    public Instant getLastGameStart() {
        return lastGameStart;
    }

    public void setLastGameStart(Instant lastGameStart) {
        this.lastGameStart = lastGameStart;
    }
}