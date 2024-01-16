package com.jpcc.CFBProject.domain.boxscore;

import jakarta.persistence.*;

@Entity
public class BoxScoreScoringOpportunities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "box_score_team_id")
    private BoxScoreTeam boxScoreTeam;

    private String team;
    private Integer opportunities;
    private Integer points;
    private Double pointsPerOpportunity;

    // Getters and setters
    // ...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BoxScoreTeam getBoxScoreTeam() {
        return boxScoreTeam;
    }

    public void setBoxScoreTeam(BoxScoreTeam boxScoreTeam) {
        this.boxScoreTeam = boxScoreTeam;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(Integer opportunities) {
        this.opportunities = opportunities;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Double getPointsPerOpportunity() {
        return pointsPerOpportunity;
    }

    public void setPointsPerOpportunity(Double pointsPerOpportunity) {
        this.pointsPerOpportunity = pointsPerOpportunity;
    }

}

