package com.jpcc.CFBProject.dto;

public class TeamChartDataDTO {
    private Long teamId;
    private String teamName;
    private Double teamAvgDistance;
    private Double teamAvgWeight;
    private Double teamAvgHeight;
    private Double teamAvgYear;
    private Double teamWinRate;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Double getTeamAvgWeight() {
        return teamAvgWeight;
    }

    public void setTeamAvgWeight(Double teamAvgWeight) {
        this.teamAvgWeight = teamAvgWeight;
    }

    public Double getTeamAvgHeight() {
        return teamAvgHeight;
    }

    public void setTeamAvgHeight(Double teamAvgHeight) {
        this.teamAvgHeight = teamAvgHeight;
    }

    public Double getTeamAvgDistance() {
        return teamAvgDistance;
    }

    public void setTeamAvgDistance(Double teamAvgDistance) {
        this.teamAvgDistance = teamAvgDistance;
    }

    public Double getTeamAvgYear() {
        return teamAvgYear;
    }

    public void setTeamAvgYear(Double teamAvgYear) {
        this.teamAvgYear = teamAvgYear;
    }

    public Double getTeamWinRate() {
        return teamWinRate;
    }

    public void setTeamWinRate(Double teamWinRate) {
        this.teamWinRate = teamWinRate;
    }

    public TeamChartDataDTO() {
    }

    public TeamChartDataDTO(Long teamId, String teamName, Double teamAvgWeight, Double teamAvgHeight, Double teamAvgDistance, Double teamAvgYear, Double teamWinRate) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamAvgWeight = teamAvgWeight;
        this.teamAvgHeight = teamAvgHeight;
        this.teamAvgDistance = teamAvgDistance;
        this.teamAvgYear = teamAvgYear;
        this.teamWinRate = teamWinRate;
    }
}
