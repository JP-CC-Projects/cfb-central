package com.jpcc.CFBProject.dto;

public class PlayerChartDataDTO {
    private Long playerId;
    private String playerFirstName;
    private String playerLastName;
    private Integer playerWeight;
    private Integer playerHeight;
    private Double playerDistance;
    private Integer playerYear;
    private String playerPosition;

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerFirstName() {
        return playerFirstName;
    }

    public void setPlayerFirstName(String playerFirstName) {
        this.playerFirstName = playerFirstName;
    }

    public String getPlayerLastName() {
        return playerLastName;
    }

    public void setPlayerLastName(String playerLastName) {
        this.playerLastName = playerLastName;
    }

    public Integer getPlayerWeight() {
        return playerWeight;
    }

    public void setPlayerWeight(Integer playerWeight) {
        this.playerWeight = playerWeight;
    }

    public Integer getPlayerHeight() {
        return playerHeight;
    }

    public void setPlayerHeight(Integer playerHeight) {
        this.playerHeight = playerHeight;
    }

    public Double getPlayerDistance() {
        return playerDistance;
    }

    public void setPlayerDistance(Double playerDistance) {
        this.playerDistance = playerDistance;
    }

    public Integer getPlayerYear() {
        return playerYear;
    }

    public void setPlayerYear(Integer playerYear) {
        this.playerYear = playerYear;
    }

    public PlayerChartDataDTO() {
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public PlayerChartDataDTO(Long playerId, String playerFirstName, String playerLastName, Integer playerWeight, Integer playerHeight, Double playerDistance, Integer playerYear, String playerPosition) {
        this.playerId = playerId;
        this.playerFirstName = playerFirstName;
        this.playerLastName = playerLastName;
        this.playerWeight = playerWeight;
        this.playerHeight = playerHeight;
        this.playerDistance = playerDistance;
        this.playerYear = playerYear;
        this.playerPosition = playerPosition;
    }
}
