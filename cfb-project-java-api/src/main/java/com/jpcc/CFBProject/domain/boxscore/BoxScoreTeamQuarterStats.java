package com.jpcc.CFBProject.domain.boxscore;

import jakarta.persistence.*;

@Embeddable
public class BoxScoreTeamQuarterStats {

    private Double total;
    private Double quarter1;
    private Double quarter2;
    private Double quarter3;
    private Double quarter4;

    // Constructors
    public BoxScoreTeamQuarterStats() {}

    public BoxScoreTeamQuarterStats(Double total, Double quarter1, Double quarter2, Double quarter3, Double quarter4) {
        this.total = total;
        this.quarter1 = quarter1;
        this.quarter2 = quarter2;
        this.quarter3 = quarter3;
        this.quarter4 = quarter4;
    }

    // Getters and setters
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getQuarter1() {
        return quarter1;
    }

    public void setQuarter1(Double quarter1) {
        this.quarter1 = quarter1;
    }

    public Double getQuarter2() {
        return quarter2;
    }

    public void setQuarter2(Double quarter2) {
        this.quarter2 = quarter2;
    }

    public Double getQuarter3() {
        return quarter3;
    }

    public void setQuarter3(Double quarter3) {
        this.quarter3 = quarter3;
    }

    public Double getQuarter4() {
        return quarter4;
    }

    public void setQuarter4(Double quarter4) {
        this.quarter4 = quarter4;
    }


}
