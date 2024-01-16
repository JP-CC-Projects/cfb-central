package com.jpcc.CFBProject.domain.boxscore;

import jakarta.persistence.*;

@Entity
public class BoxScoreHavoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "box_score_team_id")
    private BoxScoreTeam boxScoreTeam;

    private String team;
    private Double total;
    private Double frontSeven;
    private Double db;

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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getFrontSeven() {
        return frontSeven;
    }

    public void setFrontSeven(Double frontSeven) {
        this.frontSeven = frontSeven;
    }

    public Double getDb() {
        return db;
    }

    public void setDb(Double db) {
        this.db = db;
    }

}

