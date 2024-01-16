package com.jpcc.CFBProject.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "game_ppa")
public class GamePPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long gameId;
    private Integer season;
    private Integer week;
    private String team;
    private String conference;
    private String opponent;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "overall", column = @Column(name = "offense_overall")),
            @AttributeOverride(name = "passing", column = @Column(name = "offense_passing")),
            @AttributeOverride(name = "rushing", column = @Column(name = "offense_rushing")),
            @AttributeOverride(name = "firstDown", column = @Column(name = "offense_first_down")),
            @AttributeOverride(name = "secondDown", column = @Column(name = "offense_second_down")),
            @AttributeOverride(name = "thirdDown", column = @Column(name = "offense_third_down"))
    })
    private PPA offense;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "overall", column = @Column(name = "defense_overall")),
            @AttributeOverride(name = "passing", column = @Column(name = "defense_passing")),
            @AttributeOverride(name = "rushing", column = @Column(name = "defense_rushing")),
            @AttributeOverride(name = "firstDown", column = @Column(name = "defense_first_down")),
            @AttributeOverride(name = "secondDown", column = @Column(name = "defense_second_down")),
            @AttributeOverride(name = "thirdDown", column = @Column(name = "defense_third_down"))
    })
    private PPA defense;

    @Embeddable
    public static class PPA {
        private Double overall;
        private Double passing;
        private Double rushing;
        private Double firstDown;
        private Double secondDown;
        private Double thirdDown;

        // Getters and Setters

        public Double getOverall() {
            return overall;
        }

        public void setOverall(Double overall) {
            this.overall = overall;
        }

        public Double getPassing() {
            return passing;
        }

        public void setPassing(Double passing) {
            this.passing = passing;
        }

        public Double getRushing() {
            return rushing;
        }

        public void setRushing(Double rushing) {
            this.rushing = rushing;
        }

        public Double getFirstDown() {
            return firstDown;
        }

        public void setFirstDown(Double firstDown) {
            this.firstDown = firstDown;
        }

        public Double getSecondDown() {
            return secondDown;
        }

        public void setSecondDown(Double secondDown) {
            this.secondDown = secondDown;
        }

        public Double getThirdDown() {
            return thirdDown;
        }

        public void setThirdDown(Double thirdDown) {
            this.thirdDown = thirdDown;
        }
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public PPA getOffense() {
        return offense;
    }

    public void setOffense(PPA offense) {
        this.offense = offense;
    }

    public PPA getDefense() {
        return defense;
    }

    public void setDefense(PPA defense) {
        this.defense = defense;
    }
}
