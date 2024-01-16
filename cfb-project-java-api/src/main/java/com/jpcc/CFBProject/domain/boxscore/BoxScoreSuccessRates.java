package com.jpcc.CFBProject.domain.boxscore;

import jakarta.persistence.*;

@Entity
@Table(name = "box_score_success_rates")
public class BoxScoreSuccessRates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "box_score_team_id") // The foreign key column in the BoxScoreSuccessRates table
    private BoxScoreTeam boxScoreTeam;
    private String team;
    private Integer plays;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "total", column = @Column(name = "overall_total")),
            @AttributeOverride(name = "quarter1", column = @Column(name = "overall_quarter1")),
            @AttributeOverride(name = "quarter2", column = @Column(name = "overall_quarter2")),
            @AttributeOverride(name = "quarter3", column = @Column(name = "overall_quarter3")),
            @AttributeOverride(name = "quarter4", column = @Column(name = "overall_quarter4"))
    })
    private BoxScoreTeamQuarterStats overall;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "total", column = @Column(name = "std_downs_total")),
            @AttributeOverride(name = "quarter1", column = @Column(name = "std_downs_quarter1")),
            @AttributeOverride(name = "quarter2", column = @Column(name = "std_downs_quarter2")),
            @AttributeOverride(name = "quarter3", column = @Column(name = "std_downs_quarter3")),
            @AttributeOverride(name = "quarter4", column = @Column(name = "std_downs_quarter4"))
    })
    private BoxScoreTeamQuarterStats standardDowns;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "total", column = @Column(name = "passing_downs_total")),
            @AttributeOverride(name = "quarter1", column = @Column(name = "passing_downs_quarter1")),
            @AttributeOverride(name = "quarter2", column = @Column(name = "passing_downs_quarter2")),
            @AttributeOverride(name = "quarter3", column = @Column(name = "passing_downs_quarter3")),
            @AttributeOverride(name = "quarter4", column = @Column(name = "passing_downs_quarter4"))
    })
    private BoxScoreTeamQuarterStats passingDowns;

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

    public Integer getPlays() {
        return plays;
    }

    public void setPlays(Integer plays) {
        this.plays = plays;
    }

    public BoxScoreTeamQuarterStats getOverall() {
        return overall;
    }

    public void setOverall(BoxScoreTeamQuarterStats overall) {
        this.overall = overall;
    }

    public BoxScoreTeamQuarterStats getStandardDowns() {
        return standardDowns;
    }

    public void setStandardDowns(BoxScoreTeamQuarterStats standardDowns) {
        this.standardDowns = standardDowns;
    }

    public BoxScoreTeamQuarterStats getPassingDowns() {
        return passingDowns;
    }

    public void setPassingDowns(BoxScoreTeamQuarterStats passingDowns) {
        this.passingDowns = passingDowns;
    }
}
