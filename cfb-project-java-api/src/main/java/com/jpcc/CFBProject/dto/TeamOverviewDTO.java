package com.jpcc.CFBProject.dto;

import com.jpcc.CFBProject.domain.TeamRecord;

public class TeamOverviewDTO {
    private Long id;
    private String school;
    private String mascot;
    private TeamRecord teamRecord;


    public TeamOverviewDTO(Long id, String school, String mascot) {
        this.id = id;
        this.school = school;
        this.mascot = mascot;
    }

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
}