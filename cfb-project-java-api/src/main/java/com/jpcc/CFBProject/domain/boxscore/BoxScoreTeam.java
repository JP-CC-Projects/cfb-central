package com.jpcc.CFBProject.domain.boxscore;

import jakarta.persistence.*;
import java.util.List;
@Entity
public class BoxScoreTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "box_score_id")
    private BoxScore boxScore;

    @OneToMany(mappedBy = "boxScoreTeam", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoxScoreTeamPpa> ppa;

    @OneToMany(mappedBy = "boxScoreTeam", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoxScoreCumulativePpa> cumulativePpa;

    @OneToMany(mappedBy = "boxScoreTeam", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoxScoreSuccessRates> successRates;
    @OneToMany(mappedBy = "boxScoreTeam", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoxScoreExplosiveness> explosiveness;
    @OneToMany(mappedBy = "boxScoreTeam", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoxScoreRushing> rushing;

    @OneToMany(mappedBy = "boxScoreTeam", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoxScoreHavoc> havoc;

    @OneToMany(mappedBy = "boxScoreTeam", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoxScoreScoringOpportunities> scoringOpportunities;

    @OneToMany(mappedBy = "boxScoreTeam", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoxScoreFieldPosition> fieldPosition;


    // Define lists for other categories like explosiveness, rushing, havoc, scoringOpportunities, fieldPosition, etc.

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

    public List<BoxScoreTeamPpa> getPpa() {
        return ppa;
    }

    public void setPpa(List<BoxScoreTeamPpa> ppa) {
        this.ppa = ppa;
    }

    public List<BoxScoreCumulativePpa> getCumulativePpa() {
        return cumulativePpa;
    }

    public void setCumulativePpa(List<BoxScoreCumulativePpa> cumulativePpa) {
        this.cumulativePpa = cumulativePpa;
    }

    public List<BoxScoreSuccessRates> getSuccessRates() {
        return successRates;
    }

    public void setSuccessRates(List<BoxScoreSuccessRates> successRates) {
        this.successRates = successRates;
    }

    public List<BoxScoreExplosiveness> getExplosiveness() {
        return explosiveness;
    }

    public void setExplosiveness(List<BoxScoreExplosiveness> explosiveness) {
        this.explosiveness = explosiveness;
    }

    public List<BoxScoreRushing> getRushing() {
        return rushing;
    }

    public void setRushing(List<BoxScoreRushing> rushing) {
        this.rushing = rushing;
    }

    public List<BoxScoreHavoc> getHavoc() {
        return havoc;
    }

    public void setHavoc(List<BoxScoreHavoc> havoc) {
        this.havoc = havoc;
    }

    public List<BoxScoreScoringOpportunities> getScoringOpportunities() {
        return scoringOpportunities;
    }

    public void setScoringOpportunities(List<BoxScoreScoringOpportunities> scoringOpportunities) {
        this.scoringOpportunities = scoringOpportunities;
    }

    public List<BoxScoreFieldPosition> getFieldPosition() {
        return fieldPosition;
    }

    public void setFieldPosition(List<BoxScoreFieldPosition> fieldPosition) {
        this.fieldPosition = fieldPosition;
    }
}

