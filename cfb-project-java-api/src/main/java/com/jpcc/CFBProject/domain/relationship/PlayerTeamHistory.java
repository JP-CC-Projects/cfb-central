package com.jpcc.CFBProject.domain.relationship;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jpcc.CFBProject.domain.Player;
import com.jpcc.CFBProject.domain.Team;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "player_team_history")
public class PlayerTeamHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    @JsonBackReference
    private Player player;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    @JsonBackReference
    private Team team;

    private Instant startDate;
    private Instant endDate; // Null if the player is currently on the team

    public PlayerTeamHistory() {

    }

    // Constructors, getters, and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public PlayerTeamHistory(Player player, Team team, Instant startDate) {
        this.player = player;
        this.team = team;
        this.startDate = startDate;
    }
}