package com.jpcc.CFBProject.domain.boxscore;

import jakarta.persistence.*;

@Entity
public class BoxScoreExplosiveness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "box_score_team_id")
    private BoxScoreTeam boxScoreTeam;
    private String team;

    @Embedded
    private BoxScoreTeamQuarterStats overall;

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

    public BoxScoreTeamQuarterStats getOverall() {
        return overall;
    }

    public void setOverall(BoxScoreTeamQuarterStats overall) {
        this.overall = overall;
    }

}
