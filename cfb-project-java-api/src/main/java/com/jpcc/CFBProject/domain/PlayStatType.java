package com.jpcc.CFBProject.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "play_stat_type")
public class PlayStatType {

    @Id
    private Long id;
    private String name;

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
}
