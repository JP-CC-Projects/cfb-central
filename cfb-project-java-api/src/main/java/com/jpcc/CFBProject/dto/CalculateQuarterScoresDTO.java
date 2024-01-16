package com.jpcc.CFBProject.dto;

public class CalculateQuarterScoresDTO {
    private String awayTeam;
    private String homeTeam;
    private String offenseTeam;
    private Integer offenseScore;
    private String defenseTeam;
    private Integer defenseScore;
    private Integer period;
    private String playType;

    // Regular quarters


    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getOffenseTeam() {
        return offenseTeam;
    }

    public void setOffenseTeam(String offenseTeam) {
        this.offenseTeam = offenseTeam;
    }

    public Integer getOffenseScore() {
        return offenseScore;
    }

    public void setOffenseScore(Integer offenseScore) {
        this.offenseScore = offenseScore;
    }

    public String getDefenseTeam() {
        return defenseTeam;
    }

    public void setDefenseTeam(String defenseTeam) {
        this.defenseTeam = defenseTeam;
    }

    public Integer getDefenseScore() {
        return defenseScore;
    }

    public void setDefenseScore(Integer defenseScore) {
        this.defenseScore = defenseScore;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getPlayType() {
        return playType;
    }

    public void setPlayType(String playType) {
        this.playType = playType;
    }

    public CalculateQuarterScoresDTO(String awayTeam, String homeTeam, String offenseTeam, int offenseScore, String defenseTeam, int defenseScore, int period, String playType) {
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
        this.offenseTeam = offenseTeam;
        this.offenseScore = offenseScore;
        this.defenseTeam = defenseTeam;
        this.defenseScore = defenseScore;
        this.period = period;
        this.playType = playType;
    }

    @Override
    public String toString() {
        return "CalculateQuarterScoresDTO{" +
                "awayTeam='" + awayTeam + '\'' +
                ", homeTeam='" + homeTeam + '\'' +
                ", offenseTeam='" + offenseTeam + '\'' +
                ", offenseScore=" + offenseScore +
                ", defenseTeam='" + defenseTeam + '\'' +
                ", defenseScore=" + defenseScore +
                ", period=" + period +
                ", playType='" + playType + '\'' +
                '}';
    }
}
