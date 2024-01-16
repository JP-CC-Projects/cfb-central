package com.jpcc.CFBProject.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "player_game_ppa")
public class PlayerGamePPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer season;
    private Integer week;
    private String name;
    private String position;
    private String team;
    private String opponent;

    @Embedded
    private AveragePPA averagePPA;

    @Embeddable
    public static class AveragePPA {
        @Column(name = "`all`")  // Using backticks to escape reserved SQL keyword
        private Double all;
        private Double pass;
        private Double rush;

        // Getters and Setters

        public Double getAll() {
            return all;
        }

        public void setAll(Double all) {
            this.all = all;
        }

        public Double getPass() {
            return pass;
        }

        public void setPass(Double pass) {
            this.pass = pass;
        }

        public Double getRush() {
            return rush;
        }

        public void setRush(Double rush) {
            this.rush = rush;
        }
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public AveragePPA getAveragePPA() {
        return averagePPA;
    }

    public void setAveragePPA(AveragePPA averagePPA) {
        this.averagePPA = averagePPA;
    }
}
