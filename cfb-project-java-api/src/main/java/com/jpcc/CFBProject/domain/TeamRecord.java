package com.jpcc.CFBProject.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "team_records")
public class TeamRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer year;
    private Long teamId;
    private String team;
    private String conference;
    private String division;
    private Double expectedWins;

    @Embedded
    private RecordDetail total;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="games", column=@Column(name="conference_games")),
            @AttributeOverride(name="wins", column=@Column(name="conference_wins")),
            @AttributeOverride(name="losses", column=@Column(name="conference_losses")),
            @AttributeOverride(name="ties", column=@Column(name="conference_ties"))
    })
    private RecordDetail conferenceGames;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="games", column=@Column(name="home_games")),
            @AttributeOverride(name="wins", column=@Column(name="home_wins")),
            @AttributeOverride(name="losses", column=@Column(name="home_losses")),
            @AttributeOverride(name="ties", column=@Column(name="home_ties"))
    })
    private RecordDetail homeGames;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="games", column=@Column(name="away_games")),
            @AttributeOverride(name="wins", column=@Column(name="away_wins")),
            @AttributeOverride(name="losses", column=@Column(name="away_losses")),
            @AttributeOverride(name="ties", column=@Column(name="away_ties"))
    })
    private RecordDetail awayGames;

    // Nested class for total, conferenceGames, homeGames, and awayGames
    @Embeddable
    public static class RecordDetail {
        private Integer games;
        private Integer wins;
        private Integer losses;
        private Integer ties;

        public Integer getGames() {
            return games;
        }

        public void setGames(Integer games) {
            this.games = games;
        }

        public Integer getWins() {
            return wins;
        }

        public void setWins(Integer wins) {
            this.wins = wins;
        }

        public Integer getLosses() {
            return losses;
        }

        public void setLosses(Integer losses) {
            this.losses = losses;
        }

        public Integer getTies() {
            return ties;
        }

        public void setTies(Integer ties) {
            this.ties = ties;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
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

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public Double getExpectedWins() {
        return expectedWins;
    }

    public void setExpectedWins(Double expectedWins) {
        this.expectedWins = expectedWins;
    }

    public RecordDetail getTotal() {
        return total;
    }

    public void setTotal(RecordDetail total) {
        this.total = total;
    }

    public RecordDetail getConferenceGames() {
        return conferenceGames;
    }

    public void setConferenceGames(RecordDetail conferenceGames) {
        this.conferenceGames = conferenceGames;
    }

    public RecordDetail getHomeGames() {
        return homeGames;
    }

    public void setHomeGames(RecordDetail homeGames) {
        this.homeGames = homeGames;
    }

    public RecordDetail getAwayGames() {
        return awayGames;
    }

    public void setAwayGames(RecordDetail awayGames) {
        this.awayGames = awayGames;
    }
}