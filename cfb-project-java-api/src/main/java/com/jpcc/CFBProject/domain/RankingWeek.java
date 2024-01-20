package com.jpcc.CFBProject.domain;

import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "ranking_week")
public class RankingWeek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer season;
    private String seasonType;
    private Integer week;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ranking_week_id")
    private List<Poll> polls;

    @Entity
    @Table(name = "poll")
    public static class Poll {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String poll;

        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "poll_id")
        private List<Rank> ranks;

        // Getters and Setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getPoll() {
            return poll;
        }

        public void setPoll(String poll) {
            this.poll = poll;
        }

        public List<Rank> getRanks() {
            return ranks;
        }

        public void setRanks(List<Rank> ranks) {
            this.ranks = ranks;
        }
    }

    @Entity
    @Table(name = "`rank`")
    public static class Rank {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Integer rank;
        private String school;
        private String conference;
        private Integer firstPlaceVotes;
        private Integer points;

        // Getters and Setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Integer getRank() {
            return rank;
        }

        public void setRank(Integer rank) {
            this.rank = rank;
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

        public Integer getFirstPlaceVotes() {
            return firstPlaceVotes;
        }

        public void setFirstPlaceVotes(Integer firstPlaceVotes) {
            this.firstPlaceVotes = firstPlaceVotes;
        }

        public Integer getPoints() {
            return points;
        }

        public void setPoints(Integer points) {
            this.points = points;
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

    public String getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(String seasonType) {
        this.seasonType = seasonType;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public List<Poll> getPolls() {
        return polls;
    }

    public void setPolls(List<Poll> polls) {
        this.polls = polls;
    }
}