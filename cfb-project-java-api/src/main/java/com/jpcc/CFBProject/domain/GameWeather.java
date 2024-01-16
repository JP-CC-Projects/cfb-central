package com.jpcc.CFBProject.domain;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "game_weather")
public class GameWeather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer season;
    private Integer week;
    private String seasonType;
    private Instant startTime;
    private Boolean gameIndoors;
    private String homeTeam;
    private String homeConference;
    private String awayTeam;
    private String awayConference;
    private Long venueId;
    private String venue;
    private Double temperature;
    private Double dewPoint;
    private Double humidity;
    private Double precipitation;
    private Double snowfall;
    private Double windDirection;
    private Double windSpeed;
    private Double pressure;
    private Integer weatherConditionCode;
    private String weatherCondition;

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

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Boolean getGameIndoors() {
        return gameIndoors;
    }

    public void setGameIndoors(Boolean gameIndoors) {
        this.gameIndoors = gameIndoors;
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

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Double precipitation) {
        this.precipitation = precipitation;
    }

    public Double getSnowfall() {
        return snowfall;
    }

    public void setSnowfall(Double snowfall) {
        this.snowfall = snowfall;
    }

    public Double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Double windDirection) {
        this.windDirection = windDirection;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Integer getWeatherConditionCode() {
        return weatherConditionCode;
    }

    public void setWeatherConditionCode(Integer weatherConditionCode) {
        this.weatherConditionCode = weatherConditionCode;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }
}