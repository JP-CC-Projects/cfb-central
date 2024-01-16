package com.jpcc.CFBProject.domain;

import com.jpcc.CFBProject.domain.relationship.QuarterScores;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;

@Entity
public class Game {
    @Embedded
    QuarterScores quarterScores;

    public QuarterScores getQuarterScores() {
        return quarterScores;
    }

    public void setQuarterScores(QuarterScores quarterScores) {
        this.quarterScores = quarterScores;
    }

    public Integer getQ1AwayPoints() {
        return q1AwayPoints;
    }

    public void setQ1AwayPoints(Integer q1AwayPoints) {
        this.q1AwayPoints = q1AwayPoints;
    }

    public Integer getQ2HomePoints() {
        return q2HomePoints;
    }

    public void setQ2HomePoints(Integer q2HomePoints) {
        this.q2HomePoints = q2HomePoints;
    }

    public Integer getQ2AwayPoints() {
        return q2AwayPoints;
    }

    public void setQ2AwayPoints(Integer q2AwayPoints) {
        this.q2AwayPoints = q2AwayPoints;
    }

    public Integer getQ3HomePoints() {
        return q3HomePoints;
    }

    public void setQ3HomePoints(Integer q3HomePoints) {
        this.q3HomePoints = q3HomePoints;
    }

    public Integer getQ3AwayPoints() {
        return q3AwayPoints;
    }

    public void setQ3AwayPoints(Integer q3AwayPoints) {
        this.q3AwayPoints = q3AwayPoints;
    }

    public Integer getQ4HomePoints() {
        return q4HomePoints;
    }

    public void setQ4HomePoints(Integer q4HomePoints) {
        this.q4HomePoints = q4HomePoints;
    }

    public Integer getQ4AwayPoints() {
        return q4AwayPoints;
    }

    public void setQ4AwayPoints(Integer q4AwayPoints) {
        this.q4AwayPoints = q4AwayPoints;
    }

    public Integer getFinalHomePoints() {
        return finalHomePoints;
    }

    public void setFinalHomePoints(Integer finalHomePoints) {
        this.finalHomePoints = finalHomePoints;
    }

    public Integer getFinalAwayPoints() {
        return finalAwayPoints;
    }

    public void setFinalAwayPoints(Integer finalAwayPoints) {
        this.finalAwayPoints = finalAwayPoints;
    }

    @Id
    private Long id;
    private Integer season;
    private Integer week;
    private String seasonType;
    private Instant startDate;
    private Boolean startTimeTbd;
    private Boolean completed;
    private Boolean neutralSite;
    private Boolean conferenceGame;
    private Integer attendance;
    private Long venueId;
    private String venue;
    private Long homeId;
    private String homeTeam;
    private String homeConference;
    private String homeDivision;
    private Integer homePoints;
    private Integer q1HomePoints;
    private Integer q1AwayPoints;
    private Integer q2HomePoints;
    private Integer q2AwayPoints;
    private Integer q3HomePoints;
    private Integer q3AwayPoints;
    private Integer q4HomePoints;
    private Integer q4AwayPoints;
    private Integer finalHomePoints;
    private Integer finalAwayPoints;

    @ElementCollection
    private List<Integer> homeLineScores;
    private Double homePostWinProb;
    private Integer homePregameElo;
    private Integer homePostgameElo;
    private Long awayId;
    private String awayTeam;
    private String awayConference;
    private String awayDivision;
    private Integer awayPoints;
    @ElementCollection
    private List<Integer> awayLineScores;
    private Double awayPostWinProb;
    private Integer awayPregameElo;
    private Integer awayPostgameElo;
    private Double excitementIndex;
    private String highlights;
    private String notes;

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

    public String getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(String seasonType) {
        this.seasonType = seasonType;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Boolean getStartTimeTbd() {
        return startTimeTbd;
    }

    public void setStartTimeTbd(Boolean startTimeTbd) {
        this.startTimeTbd = startTimeTbd;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Boolean getNeutralSite() {
        return neutralSite;
    }

    public void setNeutralSite(Boolean neutralSite) {
        this.neutralSite = neutralSite;
    }

    public Boolean getConferenceGame() {
        return conferenceGame;
    }

    public void setConferenceGame(Boolean conferenceGame) {
        this.conferenceGame = conferenceGame;
    }

    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Long getHomeId() {
        return homeId;
    }

    public void setHomeId(Long homeId) {
        this.homeId = homeId;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getHomeConference() {
        return homeConference;
    }

    public void setHomeConference(String homeConference) {
        this.homeConference = homeConference;
    }

    public String getHomeDivision() {
        return homeDivision;
    }

    public void setHomeDivision(String homeDivision) {
        this.homeDivision = homeDivision;
    }

    public Integer getHomePoints() {
        return homePoints;
    }

    public void setHomePoints(Integer homePoints) {
        this.homePoints = homePoints;
    }

    public List<Integer> getHomeLineScores() {
        return homeLineScores;
    }

    public void setHomeLineScores(List<Integer> homeLineScores) {
        this.homeLineScores = homeLineScores;
    }

    public Double getHomePostWinProb() {
        return homePostWinProb;
    }

    public void setHomePostWinProb(Double homePostWinProb) {
        this.homePostWinProb = homePostWinProb;
    }

    public Integer getHomePregameElo() {
        return homePregameElo;
    }

    public void setHomePregameElo(Integer homePregameElo) {
        this.homePregameElo = homePregameElo;
    }

    public Integer getHomePostgameElo() {
        return homePostgameElo;
    }

    public void setHomePostgameElo(Integer homePostgameElo) {
        this.homePostgameElo = homePostgameElo;
    }

    public Long getAwayId() {
        return awayId;
    }

    public void setAwayId(Long awayId) {
        this.awayId = awayId;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getAwayConference() {
        return awayConference;
    }

    public void setAwayConference(String awayConference) {
        this.awayConference = awayConference;
    }

    public String getAwayDivision() {
        return awayDivision;
    }

    public void setAwayDivision(String awayDivision) {
        this.awayDivision = awayDivision;
    }

    public Integer getAwayPoints() {
        return awayPoints;
    }

    public void setAwayPoints(Integer awayPoints) {
        this.awayPoints = awayPoints;
    }

    public List<Integer> getAwayLineScores() {
        return awayLineScores;
    }

    public void setAwayLineScores(List<Integer> awayLineScores) {
        this.awayLineScores = awayLineScores;
    }

    public Double getAwayPostWinProb() {
        return awayPostWinProb;
    }

    public void setAwayPostWinProb(Double awayPostWinProb) {
        this.awayPostWinProb = awayPostWinProb;
    }

    public Integer getAwayPregameElo() {
        return awayPregameElo;
    }

    public void setAwayPregameElo(Integer awayPregameElo) {
        this.awayPregameElo = awayPregameElo;
    }

    public Integer getAwayPostgameElo() {
        return awayPostgameElo;
    }

    public void setAwayPostgameElo(Integer awayPostgameElo) {
        this.awayPostgameElo = awayPostgameElo;
    }

    public Double getExcitementIndex() {
        return excitementIndex;
    }

    public void setExcitementIndex(Double excitementIndex) {
        this.excitementIndex = excitementIndex;
    }

    public String getHighlights() {
        return highlights;
    }

    public void setHighlights(String highlights) {
        this.highlights = highlights;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getQ1HomePoints() {
        return q1HomePoints;
    }

    public void setQ1HomePoints(Integer q1HomePoints) {
        this.q1HomePoints = q1HomePoints;
    }
}
