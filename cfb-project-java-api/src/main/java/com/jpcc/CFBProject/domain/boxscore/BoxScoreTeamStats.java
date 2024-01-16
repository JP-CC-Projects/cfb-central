//package com.jpcc.CFBProject.domain.boxscore;
//
//import jakarta.persistence.*;
//
//@Entity
//public class BoxScoreTeamStats {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "box_score_team_id")
//    private BoxScoreTeam boxScoreTeam;
//
//    private String team;
//    private Integer plays;
//
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "total", column = @Column(name = "overall_total")),
//            @AttributeOverride(name = "quarter1", column = @Column(name = "overall_quarter1")),
//            @AttributeOverride(name = "quarter2", column = @Column(name = "overall_quarter2")),
//            @AttributeOverride(name = "quarter3", column = @Column(name = "overall_quarter3")),
//            @AttributeOverride(name = "quarter4", column = @Column(name = "overall_quarter4"))
//    })
//    private BoxScoreTeamQuarterStats overall;
//
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "total", column = @Column(name = "passing_total")),
//            @AttributeOverride(name = "quarter1", column = @Column(name = "passing_quarter1")),
//            @AttributeOverride(name = "quarter2", column = @Column(name = "passing_quarter2")),
//            @AttributeOverride(name = "quarter3", column = @Column(name = "passing_quarter3")),
//            @AttributeOverride(name = "quarter4", column = @Column(name = "passing_quarter4"))
//    })
//    private BoxScoreTeamQuarterStats passing;
//
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "total", column = @Column(name = "rushing_total")),
//            @AttributeOverride(name = "quarter1", column = @Column(name = "rushing_quarter1")),
//            @AttributeOverride(name = "quarter2", column = @Column(name = "rushing_quarter2")),
//            @AttributeOverride(name = "quarter3", column = @Column(name = "rushing_quarter3")),
//            @AttributeOverride(name = "quarter4", column = @Column(name = "rushing_quarter4"))
//    })
//    private BoxScoreTeamQuarterStats rushing;
//
//
//    // Include fields for other stats like standardDowns, passingDowns, etc., as embedded objects
//
//    // Getters and setters
//
//
//    public BoxScoreTeam getBoxScoreTeam() {
//        return boxScoreTeam;
//    }
//
//    public void setBoxScoreTeam(BoxScoreTeam boxScoreTeam) {
//        this.boxScoreTeam = boxScoreTeam;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTeam() {
//        return team;
//    }
//
//    public void setTeam(String team) {
//        this.team = team;
//    }
//
//    public Integer getPlays() {
//        return plays;
//    }
//
//    public void setPlays(Integer plays) {
//        this.plays = plays;
//    }
//
//    public BoxScoreTeamQuarterStats getOverall() {
//        return overall;
//    }
//
//    public void setOverall(BoxScoreTeamQuarterStats overall) {
//        this.overall = overall;
//    }
//
//    public BoxScoreTeamQuarterStats getPassing() {
//        return passing;
//    }
//
//    public void setPassing(BoxScoreTeamQuarterStats passing) {
//        this.passing = passing;
//    }
//
//    public BoxScoreTeamQuarterStats getRushing() {
//        return rushing;
//    }
//
//    public void setRushing(BoxScoreTeamQuarterStats rushing) {
//        this.rushing = rushing;
//    }
//
//}
