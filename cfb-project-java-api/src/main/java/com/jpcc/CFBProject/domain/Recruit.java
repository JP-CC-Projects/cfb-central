package com.jpcc.CFBProject.domain;

import jakarta.persistence.*;
@Entity
@Table(name = "recruit")
public class Recruit {

    @Id
    private Long id;
    private Long athleteId;
    private String recruitType;
    private Integer year;
    private Integer ranking;
    private String name;
    private String school;
    private String committedTo;
    private String position;
    private Double height;
    private Integer weight;
    private Integer stars;
    private Double rating;
    private String city;
    private String stateProvince;
    private String country;

    @Embedded
    private HometownInfo hometownInfo;

    @Embeddable
    public static class HometownInfo {
        private Double latitude;
        private Double longitude;
        private String countyFips;

        // Getters and Setters

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public String getCountyFips() {
            return countyFips;
        }

        public void setCountyFips(String countyFips) {
            this.countyFips = countyFips;
        }
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(Long athleteId) {
        this.athleteId = athleteId;
    }

    public String getRecruitType() {
        return recruitType;
    }

    public void setRecruitType(String recruitType) {
        this.recruitType = recruitType;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCommittedTo() {
        return committedTo;
    }

    public void setCommittedTo(String committedTo) {
        this.committedTo = committedTo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public HometownInfo getHometownInfo() {
        return hometownInfo;
    }

    public void setHometownInfo(HometownInfo hometownInfo) {
        this.hometownInfo = hometownInfo;
    }
}


