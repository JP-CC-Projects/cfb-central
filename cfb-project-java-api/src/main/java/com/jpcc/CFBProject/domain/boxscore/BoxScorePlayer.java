package com.jpcc.CFBProject.domain.boxscore;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class BoxScorePlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "box_score_id")
    private BoxScore boxScore;

    @OneToMany(mappedBy = "boxScorePlayer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoxScorePlayerUsage> usage;

    @OneToMany(mappedBy = "boxScorePlayer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoxScorePlayerPpa> ppa;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BoxScore getBoxScore() {
        return boxScore;
    }

    public void setBoxScore(BoxScore boxScore) {
        this.boxScore = boxScore;
    }

    public List<BoxScorePlayerUsage> getUsage() {
        return usage;
    }

    public void setUsage(List<BoxScorePlayerUsage> usage) {
        this.usage = usage;
    }

    public List<BoxScorePlayerPpa> getPpa() {
        return ppa;
    }

    public void setPpa(List<BoxScorePlayerPpa> ppa) {
        this.ppa = ppa;
    }

}
