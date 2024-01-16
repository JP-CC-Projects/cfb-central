package com.jpcc.CFBProject.domain.boxscore;
import jakarta.persistence.*;

@Embeddable
public class BoxScorePlayerStats {
    private String player;
    private String team;
    private String position;
    private Double total;
    private Double quarter1;
    private Double quarter2;
    private Double quarter3;
    private Double quarter4;
    private Double rushing;
    private Double passing;

    // Getters and setters

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getQuarter1() {
        return quarter1;
    }

    public void setQuarter1(Double quarter1) {
        this.quarter1 = quarter1;
    }

    public Double getQuarter2() {
        return quarter2;
    }

    public void setQuarter2(Double quarter2) {
        this.quarter2 = quarter2;
    }

    public Double getQuarter3() {
        return quarter3;
    }

    public void setQuarter3(Double quarter3) {
        this.quarter3 = quarter3;
    }

    public Double getQuarter4() {
        return quarter4;
    }

    public void setQuarter4(Double quarter4) {
        this.quarter4 = quarter4;
    }

    public Double getRushing() {
        return rushing;
    }

    public void setRushing(Double rushing) {
        this.rushing = rushing;
    }

    public Double getPassing() {
        return passing;
    }

    public void setPassing(Double passing) {
        this.passing = passing;
    }
}

