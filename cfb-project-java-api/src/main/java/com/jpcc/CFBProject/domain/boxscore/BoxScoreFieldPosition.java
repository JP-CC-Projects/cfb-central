package com.jpcc.CFBProject.domain.boxscore;

import jakarta.persistence.*;

@Entity
public class BoxScoreFieldPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "box_score_team_id")
    private BoxScoreTeam boxScoreTeam;
    private String team;
    private Double averageStart;
    private Double averageStartingPredictedPoints;

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

    public Double getAverageStart() {
        return averageStart;
    }

    public void setAverageStart(Double averageStart) {
        this.averageStart = averageStart;
    }

    public Double getAverageStartingPredictedPoints() {
        return averageStartingPredictedPoints;
    }

    public void setAverageStartingPredictedPoints(Double averageStartingPredictedPoints) {
        this.averageStartingPredictedPoints = averageStartingPredictedPoints;
    }

}
