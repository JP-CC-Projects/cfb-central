package com.jpcc.CFBProject.domain;

import jakarta.persistence.*;


@Entity
@Table(name = "venue")
public class Venue {

    @Id
    private Long id;
    private String name;
    private Integer capacity;
    private Boolean grass;
    private String city;
    private String state;
    private String zip;
    private String countryCode;

    @Embedded
    private Location location;

    private Double elevation;
    private Integer yearConstructed;
    private Boolean dome;
    private String timezone;

    @Embeddable
    public static class Location {
        private Double x;
        private Double y;

        // Getters and Setters

        public Double getX() {
            return x;
        }

        public void setX(Double x) {
            this.x = x;
        }

        public Double getY() {
            return y;
        }

        public void setY(Double y) {
            this.y = y;
        }
    }

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Boolean getGrass() {
        return grass;
    }

    public void setGrass(Boolean grass) {
        this.grass = grass;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Double getElevation() {
        return elevation;
    }

    public void setElevation(Double elevation) {
        this.elevation = elevation;
    }

    public Integer getYearConstructed() {
        return yearConstructed;
    }

    public void setYearConstructed(Integer yearConstructed) {
        this.yearConstructed = yearConstructed;
    }

    public Boolean getDome() {
        return dome;
    }

    public void setDome(Boolean dome) {
        this.dome = dome;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}