package com.jpcc.CFBProject.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "team_game")
public class TeamGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "team_game_id")
    private List<TeamInfo> teams;

    @Entity
    @Table(name = "team_info")
    public static class TeamInfo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Long schoolId;
        private String school;
        private String conference;
        private String homeAway;
        private Integer points;

        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "team_info_id")
        private List<Stat> stats;

        // Getters and Setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getSchoolId() {
            return schoolId;
        }

        public void setSchoolId(Long schoolId) {
            this.schoolId = schoolId;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getConference() {
            return conference;
        }

        public void setConference(String conference) {
            this.conference = conference;
        }

        public String getHomeAway() {
            return homeAway;
        }

        public void setHomeAway(String homeAway) {
            this.homeAway = homeAway;
        }

        public Integer getPoints() {
            return points;
        }

        public void setPoints(Integer points) {
            this.points = points;
        }

        public List<Stat> getStats() {
            return stats;
        }

        public void setStats(List<Stat> stats) {
            this.stats = stats;
        }
    }

    @Entity
    @Table(name = "team_stats")
    public static class Stat {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String category;
        private String stat;

        // Getters and Setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }
    }

    // Getters and Setters for TeamGame

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TeamInfo> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamInfo> teams) {
        this.teams = teams;
    }
}