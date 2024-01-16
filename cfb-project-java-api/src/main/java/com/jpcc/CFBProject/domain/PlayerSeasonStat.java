package com.jpcc.CFBProject.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "player_season_stat")
public class PlayerSeasonStat {

    @Id
    private Long id;
    private Integer season;
    private String name;
    private String position;
    private String team;
    private String conference;

    @Embedded
    private PPAData averagePPA;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "all", column = @Column(name = "total_ppa_all")),
            @AttributeOverride(name = "pass", column = @Column(name = "total_ppa_pass")),
            @AttributeOverride(name = "rush", column = @Column(name = "total_ppa_rush")),
            @AttributeOverride(name = "firstDown", column = @Column(name = "total_ppa_first_down")),
            @AttributeOverride(name = "secondDown", column = @Column(name = "total_ppa_second_down")),
            @AttributeOverride(name = "thirdDown", column = @Column(name = "total_ppa_third_down")),
            @AttributeOverride(name = "standardDowns", column = @Column(name = "total_ppa_standard_downs")),
            @AttributeOverride(name = "passingDowns", column = @Column(name = "total_ppa_passing_downs"))
    })
    private PPAData totalPPA;

    @Embeddable
    public static class PPAData {
        private Double all;
        private Double pass;
        private Double rush;
        private Double firstDown;
        private Double secondDown;
        private Double thirdDown;
        private Double standardDowns;
        private Double passingDowns;

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

        public Double getStandardDowns() {
            return standardDowns;
        }

        public void setStandardDowns(Double standardDowns) {
            this.standardDowns = standardDowns;
        }

        public Double getPassingDowns() {
            return passingDowns;
        }

        public void setPassingDowns(Double passingDowns) {
            this.passingDowns = passingDowns;
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

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public PPAData getAveragePPA() {
        return averagePPA;
    }

    public void setAveragePPA(PPAData averagePPA) {
        this.averagePPA = averagePPA;
    }

    public PPAData getTotalPPA() {
        return totalPPA;
    }

    public void setTotalPPA(PPAData totalPPA) {
        this.totalPPA = totalPPA;
    }
}
