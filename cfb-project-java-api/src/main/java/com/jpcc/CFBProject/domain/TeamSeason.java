package com.jpcc.CFBProject.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "team_season")
public class TeamSeason {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String school;
    private Integer year;
    private Integer games;
    private Integer wins;
    private Integer losses;
    private Integer ties;
    private Integer preseasonRank; // Rank in the AP preseason poll
    private Integer postseasonRank; // Final ranking in the AP poll
    private Double srs; // Final SRS rankings
    private Double spOverall; // Final overall SP+ rating
    private Double spOffense; // Final SP+ offensive rating
    private Double spDefense; // Final SP+ defensive rating

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public Integer getTies() {
        return ties;
    }

    public void setTies(Integer ties) {
        this.ties = ties;
    }

    public Integer getPreseasonRank() {
        return preseasonRank;
    }

    public void setPreseasonRank(Integer preseasonRank) {
        this.preseasonRank = preseasonRank;
    }

    public Integer getPostseasonRank() {
        return postseasonRank;
    }

    public void setPostseasonRank(Integer postseasonRank) {
        this.postseasonRank = postseasonRank;
    }

    public Double getSrs() {
        return srs;
    }

    public void setSrs(Double srs) {
        this.srs = srs;
    }

    public Double getSpOverall() {
        return spOverall;
    }

    public void setSpOverall(Double spOverall) {
        this.spOverall = spOverall;
    }

    public Double getSpOffense() {
        return spOffense;
    }

    public void setSpOffense(Double spOffense) {
        this.spOffense = spOffense;
    }

    public Double getSpDefense() {
        return spDefense;
    }

    public void setSpDefense(Double spDefense) {
        this.spDefense = spDefense;
    }
}