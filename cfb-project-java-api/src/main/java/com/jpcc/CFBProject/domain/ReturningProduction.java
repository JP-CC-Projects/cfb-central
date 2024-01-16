package com.jpcc.CFBProject.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "returning_production")
public class ReturningProduction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer season;
    private String team;
    private String conference;
    private Double totalPPA;
    private Double totalPassingPPA;
    private Double totalReceivingPPA;
    private Double totalRushingPPA;
    private Double percentPPA;
    private Double percentPassingPPA;
    private Double percentReceivingPPA;
    private Double percentRushingPPA;
    private Double usage;
    private Double passingUsage;
    private Double receivingUsage;
    private Double rushingUsage;

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

    public Double getTotalPPA() {
        return totalPPA;
    }

    public void setTotalPPA(Double totalPPA) {
        this.totalPPA = totalPPA;
    }

    public Double getTotalPassingPPA() {
        return totalPassingPPA;
    }

    public void setTotalPassingPPA(Double totalPassingPPA) {
        this.totalPassingPPA = totalPassingPPA;
    }

    public Double getTotalReceivingPPA() {
        return totalReceivingPPA;
    }

    public void setTotalReceivingPPA(Double totalReceivingPPA) {
        this.totalReceivingPPA = totalReceivingPPA;
    }

    public Double getTotalRushingPPA() {
        return totalRushingPPA;
    }

    public void setTotalRushingPPA(Double totalRushingPPA) {
        this.totalRushingPPA = totalRushingPPA;
    }

    public Double getPercentPPA() {
        return percentPPA;
    }

    public void setPercentPPA(Double percentPPA) {
        this.percentPPA = percentPPA;
    }

    public Double getPercentPassingPPA() {
        return percentPassingPPA;
    }

    public void setPercentPassingPPA(Double percentPassingPPA) {
        this.percentPassingPPA = percentPassingPPA;
    }

    public Double getPercentReceivingPPA() {
        return percentReceivingPPA;
    }

    public void setPercentReceivingPPA(Double percentReceivingPPA) {
        this.percentReceivingPPA = percentReceivingPPA;
    }

    public Double getPercentRushingPPA() {
        return percentRushingPPA;
    }

    public void setPercentRushingPPA(Double percentRushingPPA) {
        this.percentRushingPPA = percentRushingPPA;
    }

    public Double getUsage() {
        return usage;
    }

    public void setUsage(Double usage) {
        this.usage = usage;
    }

    public Double getPassingUsage() {
        return passingUsage;
    }

    public void setPassingUsage(Double passingUsage) {
        this.passingUsage = passingUsage;
    }

    public Double getReceivingUsage() {
        return receivingUsage;
    }

    public void setReceivingUsage(Double receivingUsage) {
        this.receivingUsage = receivingUsage;
    }

    public Double getRushingUsage() {
        return rushingUsage;
    }

    public void setRushingUsage(Double rushingUsage) {
        this.rushingUsage = rushingUsage;
    }
}
