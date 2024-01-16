package com.jpcc.CFBProject.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "field_goal_expected_points")
public class FieldGoalExpectedPoints {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer yardsToGoal;
    private Integer distance;
    private Double expectedPoints;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYardsToGoal() {
        return yardsToGoal;
    }

    public void setYardsToGoal(Integer yardsToGoal) {
        this.yardsToGoal = yardsToGoal;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Double getExpectedPoints() {
        return expectedPoints;
    }

    public void setExpectedPoints(Double expectedPoints) {
        this.expectedPoints = expectedPoints;
    }
}
