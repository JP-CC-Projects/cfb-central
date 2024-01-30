package com.jpcc.CFBProject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jpcc.CFBProject.domain.relationship.PlayerTeamHistory;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "team")
public class Team {
    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private Set<PlayerTeamHistory> playerTeamHistories = new HashSet<>();

    public Set<PlayerTeamHistory> getPlayerTeamHistories() {
        return playerTeamHistories;
    }
    public void setPlayerTeamHistories(Set<PlayerTeamHistory> playerTeamHistories) {
        this.playerTeamHistories = playerTeamHistories;
    }

    @Id
    private Long id;
    @Column(unique = true) // Ensure team names are unique
    private String school;
    private String mascot;
    private String abbreviation;
    private String altName1;
    private String altName2;
    private String altName3;
    private String classification;
    private String conference;
    private String division;
    private String color;
    private String altColor;

    @ElementCollection
    @CollectionTable(name = "team_logos", joinColumns = @JoinColumn(name = "team_id"))
    @Column(name = "logo")
    private List<String> logos;

    private String twitter;

    @Embedded
    private Location location;

    @Embeddable
    public static class Location {
        private Long venueId;
        private String name;
        @Column(length = 2048, nullable = true)
        private String venueImageUrl;
        private String city;
        private String state;
        private String zip;
        private String countryCode;
        private String timezone;
        private Double latitude;
        private Double longitude;
        private Double elevation;
        private Integer capacity;
        private Integer yearConstructed;
        private Boolean grass;
        private Boolean dome;

        // Getters and Setters

        public Long getVenueId() {
            return venueId;
        }

        public void setVenueId(Long venueId) {
            this.venueId = venueId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getVenueImageUrl() {
            return venueImageUrl;
        }

        public void setVenueImageUrl(String venueImageUrl) {
            this.venueImageUrl = venueImageUrl;
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

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

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

        public Double getElevation() {
            return elevation;
        }

        public void setElevation(Double elevation) {
            this.elevation = elevation;
        }

        public Integer getCapacity() {
            return capacity;
        }

        public void setCapacity(Integer capacity) {
            this.capacity = capacity;
        }

        public Integer getYearConstructed() {
            return yearConstructed;
        }

        public void setYearConstructed(Integer yearConstructed) {
            this.yearConstructed = yearConstructed;
        }

        public Boolean getGrass() {
            return grass;
        }

        public void setGrass(Boolean grass) {
            this.grass = grass;
        }

        public Boolean getDome() {
            return dome;
        }

        public void setDome(Boolean dome) {
            this.dome = dome;
        }
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMascot() {
        return mascot;
    }

    public void setMascot(String mascot) {
        this.mascot = mascot;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAltName1() {
        return altName1;
    }

    public void setAltName1(String altName1) {
        this.altName1 = altName1;
    }

    public String getAltName2() {
        return altName2;
    }

    public void setAltName2(String altName2) {
        this.altName2 = altName2;
    }

    public String getAltName3() {
        return altName3;
    }

    public void setAltName3(String altName3) {
        this.altName3 = altName3;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAltColor() {
        return altColor;
    }

    public void setAltColor(String altColor) {
        this.altColor = altColor;
    }

    public List<String> getLogos() {
        return logos;
    }

    public void setLogos(List<String> logos) {
        this.logos = logos;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Team() {
    }

    public Team(String school, String abbreviation) {
        this.school = school;
        this.abbreviation = abbreviation;
    }
}