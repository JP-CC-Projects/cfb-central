package com.jpcc.CFBProject.domain.boxscore;

import jakarta.persistence.*;

@Entity
public class BoxScorePlayerPpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "box_score_player_id")
    private BoxScorePlayer boxScorePlayer;

    private String player;
    private String team;
    private String position;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "total", column = @Column(name = "average_total")),
            @AttributeOverride(name = "quarter1", column = @Column(name = "average_quarter1")),
            @AttributeOverride(name = "quarter2", column = @Column(name = "average_quarter2")),
            @AttributeOverride(name = "quarter3", column = @Column(name = "average_quarter3")),
            @AttributeOverride(name = "quarter4", column = @Column(name = "average_quarter4")),
            @AttributeOverride(name = "rushing", column = @Column(name = "average_rushing")),
            @AttributeOverride(name = "passing", column = @Column(name = "average_passing"))
    })
    private BoxScorePlayerQuarterStats average;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "total", column = @Column(name = "cumulative_total")),
            @AttributeOverride(name = "quarter1", column = @Column(name = "cumulative_quarter1")),
            @AttributeOverride(name = "quarter2", column = @Column(name = "cumulative_quarter2")),
            @AttributeOverride(name = "quarter3", column = @Column(name = "cumulative_quarter3")),
            @AttributeOverride(name = "quarter4", column = @Column(name = "cumulative_quarter4")),
            @AttributeOverride(name = "rushing", column = @Column(name = "cumulative_rushing")),
            @AttributeOverride(name = "passing", column = @Column(name = "cumulative_passing"))
    })
    private BoxScorePlayerQuarterStats cumulative;



    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BoxScorePlayer getBoxScorePlayer() {
        return boxScorePlayer;
    }

    public void setBoxScorePlayer(BoxScorePlayer boxScorePlayer) {
        this.boxScorePlayer = boxScorePlayer;
    }

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

    public BoxScorePlayerQuarterStats getAverage() {
        return average;
    }

    public void setAverage(BoxScorePlayerQuarterStats average) {
        this.average = average;
    }

    public BoxScorePlayerQuarterStats getCumulative() {
        return cumulative;
    }

    public void setCumulative(BoxScorePlayerQuarterStats cumulative) {
        this.cumulative = cumulative;
    }
}
