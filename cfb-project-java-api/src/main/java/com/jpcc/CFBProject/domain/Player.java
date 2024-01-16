package com.jpcc.CFBProject.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jpcc.CFBProject.domain.relationship.PlayerTeamHistory;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "player")
public class Player {

    @ManyToOne
    @JsonManagedReference
    private PlayerTeamHistory playerTeamHistory;

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String team; //AKA player's current school
    private Integer height;
    private Integer weight;
    private Integer jersey;
    private Integer year;
    private String position;
    private String homeCity;
    private String homeState;
    private String homeCountry;
    private Double homeLatitude;
    private Double homeLongitude;
    private String homeCountyFips;
    private Boolean onOffense;
    private Boolean onDefense;
    private Boolean onSpecialTeams;
    private Double distanceToSchool;

    @ElementCollection
    @CollectionTable(name = "player_recruit_ids", joinColumns = @JoinColumn(name = "player_id"))
    @Column(name = "recruit_id")
    private List<Integer> recruitIds;

    // Getters and Setters


    public PlayerTeamHistory getPlayerTeamHistory() {
        return playerTeamHistory;
    }

    public void setPlayerTeamHistory(PlayerTeamHistory playerTeamHistory) {
        this.playerTeamHistory = playerTeamHistory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getJersey() {
        return jersey;
    }

    public void setJersey(Integer jersey) {
        this.jersey = jersey;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    public String getHomeState() {
        return homeState;
    }

    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }

    public String getHomeCountry() {
        return homeCountry;
    }

    public void setHomeCountry(String homeCountry) {
        this.homeCountry = homeCountry;
    }

    public Double getHomeLatitude() {
        return homeLatitude;
    }

    public void setHomeLatitude(Double homeLatitude) {
        this.homeLatitude = homeLatitude;
    }

    public Double getHomeLongitude() {
        return homeLongitude;
    }

    public void setHomeLongitude(Double homeLongitude) {
        this.homeLongitude = homeLongitude;
    }

    public String getHomeCountyFips() {
        return homeCountyFips;
    }

    public void setHomeCountyFips(String homeCountyFips) {
        this.homeCountyFips = homeCountyFips;
    }

    public List<Integer> getRecruitIds() {
        return recruitIds;
    }

    public void setRecruitIds(List<Integer> recruitIds) {
        this.recruitIds = recruitIds;
    }

    public Boolean getOnOffense() {
        return onOffense;
    }

    public void setOnOffense(Boolean onOffense) {
        this.onOffense = onOffense;
    }

    public Boolean getOnDefense() {
        return onDefense;
    }

    public void setOnDefense(Boolean onDefense) {
        this.onDefense = onDefense;
    }

    public Boolean getOnSpecialTeams() {
        return onSpecialTeams;
    }

    public void setOnSpecialTeams(Boolean onSpecialTeams) {
        this.onSpecialTeams = onSpecialTeams;
    }

    public Double getDistanceToSchool() {
        return distanceToSchool;
    }

    public void setDistanceToSchool(Double distanceToSchool) {
        this.distanceToSchool = distanceToSchool;
    }
}