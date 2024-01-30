package com.jpcc.CFBProject.domain;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "nation_chart_data")
public class NationChartData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "updated_at")
    private Instant updatedAt;
    private Integer season;
    private Double natAvgWeight;
    private Double natAvgHeight;
    private Double natAvgDistance;
    private Double natAvgYear;

    // Constructors
    public NationChartData() {
    }

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

    public Double getNatAvgWeight() {
        return natAvgWeight;
    }

    public void setNatAvgWeight(Double natAvgWeight) {
        this.natAvgWeight = natAvgWeight;
    }

    public Double getNatAvgHeight() {
        return natAvgHeight;
    }

    public void setNatAvgHeight(Double natAvgHeight) {
        this.natAvgHeight = natAvgHeight;
    }

    public Double getNatAvgDistance() {
        return natAvgDistance;
    }

    public void setNatAvgDistance(Double natAvgDistance) {
        this.natAvgDistance = natAvgDistance;
    }

    public Double getNatAvgYear() {
        return natAvgYear;
    }

    public void setNatAvgYear(Double natAvgYear) {
        this.natAvgYear = natAvgYear;
    }
}