package com.jpcc.CFBProject.dto;

import java.util.List;

public class NationChartDataDTO {
    private Double natAvgWeight;
    private Double natAvgHeight;
    private Double natAvgDistance;
    private Double natAvgYear;

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

    public NationChartDataDTO() {
    }

    public NationChartDataDTO(Double natAvgWeight, Double natAvgHeight, Double natAvgDistance, Double natAvgYear) {
        this.natAvgWeight = natAvgWeight;
        this.natAvgHeight = natAvgHeight;
        this.natAvgDistance = natAvgDistance;
        this.natAvgYear = natAvgYear;
    }
}