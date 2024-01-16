package com.jpcc.CFBProject.domain.boxscore;

import jakarta.persistence.*;

@Entity
public class BoxScoreRushing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "box_score_team_id")
    private BoxScoreTeam boxScoreTeam;

    private String team;
    private Double powerSuccess;
    private Double stuffRate;
    private Double lineYards;
    private Double lineYardsAverage;
    private Integer secondLevelYards;
    private Double secondLevelYardsAverage;
    private Integer openFieldYards;
    private Double openFieldYardsAverage;

    // Getters and setters
    // ...


    public BoxScoreTeam getBoxScoreTeam() {
        return boxScoreTeam;
    }

    public void setBoxScoreTeam(BoxScoreTeam boxScoreTeam) {
        this.boxScoreTeam = boxScoreTeam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Double getPowerSuccess() {
        return powerSuccess;
    }

    public void setPowerSuccess(Double powerSuccess) {
        this.powerSuccess = powerSuccess;
    }

    public Double getStuffRate() {
        return stuffRate;
    }

    public void setStuffRate(Double stuffRate) {
        this.stuffRate = stuffRate;
    }

    public Double getLineYards() {
        return lineYards;
    }

    public void setLineYards(Double lineYards) {
        this.lineYards = lineYards;
    }

    public Double getLineYardsAverage() {
        return lineYardsAverage;
    }

    public void setLineYardsAverage(Double lineYardsAverage) {
        this.lineYardsAverage = lineYardsAverage;
    }

    public Integer getSecondLevelYards() {
        return secondLevelYards;
    }

    public void setSecondLevelYards(Integer secondLevelYards) {
        this.secondLevelYards = secondLevelYards;
    }

    public Double getSecondLevelYardsAverage() {
        return secondLevelYardsAverage;
    }

    public void setSecondLevelYardsAverage(Double secondLevelYardsAverage) {
        this.secondLevelYardsAverage = secondLevelYardsAverage;
    }

    public Integer getOpenFieldYards() {
        return openFieldYards;
    }

    public void setOpenFieldYards(Integer openFieldYards) {
        this.openFieldYards = openFieldYards;
    }

    public Double getOpenFieldYardsAverage() {
        return openFieldYardsAverage;
    }

    public void setOpenFieldYardsAverage(Double openFieldYardsAverage) {
        this.openFieldYardsAverage = openFieldYardsAverage;
    }

}