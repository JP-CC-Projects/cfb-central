package com.jpcc.CFBProject.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "player_search_result")
public class PlayerSearchResult {

    @Id
    private Long id;
    private String team;
    private String name;
    private String firstName;
    private String lastName;
    private Integer weight;
    private Integer height;
    private Integer jersey;
    private String position;
    private String hometown;
    private String teamColor;
    private String teamColorSecondary;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getJersey() {
        return jersey;
    }

    public void setJersey(Integer jersey) {
        this.jersey = jersey;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    public String getTeamColorSecondary() {
        return teamColorSecondary;
    }

    public void setTeamColorSecondary(String teamColorSecondary) {
        this.teamColorSecondary = teamColorSecondary;
    }
}
